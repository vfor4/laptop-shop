package com.laptopshop.config.stateless;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.SaveContextOnUpdateOrErrorResponseWrapper;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptopshop.ulti.RSAUtil;

import java.security.interfaces.RSAPrivateKey;
import java.util.Date;

public class JWTSecurityContextRepository implements SecurityContextRepository {
    private static final Logger log = LoggerFactory.getLogger(JWTSecurityContextRepository.class);

    @Autowired
    private RSAUtil rsaUtil;

    private final UserDetailsService userDetailsManager;
    private final String tokenName;

    public JWTSecurityContextRepository(UserDetailsService userDetailsManager, String tokenName) {
        this.userDetailsManager = userDetailsManager;
        this.tokenName = tokenName;
    }

    @Override
    public SecurityContext loadContext(HttpRequestResponseHolder requestResponseHolder) {
        HttpServletRequest request = requestResponseHolder.getRequest();
        HttpServletResponse response = requestResponseHolder.getResponse();
        
        // log.info("loadContext " + "req: " + request.getServletPath());
        try {
            requestResponseHolder.setResponse(
                new SaveToCookieResponseWrapper(request, response, tokenName, rsaUtil.readPrivateKey()));
        } catch (Exception e) {
            log.info("private key cannot query");
        }
        SecurityContext context = readSecurityContextFromCookie(request);
        if (context == null) {
            return SecurityContextHolder.createEmptyContext();
        }
        return context;
    }

    private SecurityContext readSecurityContextFromCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        // log.info("readSecurityContextFromCookie " + cookies);
        
        if (cookies == null) {
            return null;
        } else {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(tokenName)) {
                    try {
                        String username = Jwts.parser().setSigningKey(
                            rsaUtil.readPublicKey()).parse(cookie.getValue(), new JwtHandlerAdapter<String>() {
                            @Override
                            public String onClaimsJws(Jws<Claims> jws) {
                                return jws.getBody().getSubject();
                            }
                        });
                        SecurityContext context = SecurityContextHolder.createEmptyContext();
                        UserDetails userDetails = this.userDetailsManager.loadUserByUsername(username);
                        context.setAuthentication(new UsernamePasswordAuthenticationToken(
                            userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities()));
                        return context;
                    } catch (ExpiredJwtException ex) {
                        log.debug("authentication cookie is expired");
                    } catch (UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException e) {
                        log.warn("tampered jwt authentication cookie detected");
                        return null;
                    } catch (Exception e) {
                        // log.info("program have got problem with key pairs");
                        e.printStackTrace();
                    }
                }
            }
        }
        log.debug("no [{}] found in request.", tokenName);
        return null;
    }


    @Override
    public void saveContext(SecurityContext context, HttpServletRequest request, HttpServletResponse response) {
        // log.info("saveContext " + request.getCookies());
        SaveToCookieResponseWrapper responseWrapper = (SaveToCookieResponseWrapper) response;
        if (!responseWrapper.isContextSaved()) {
            // log.info("isContextSaved true");
            responseWrapper.saveContext(context);
        }

    }

    @Override
    public boolean containsContext(HttpServletRequest request) {
        boolean result =  readSecurityContextFromCookie(request) != null;
        // log.info("containsContext " + result);
        return result;
    }

    private static class SaveToCookieResponseWrapper extends SaveContextOnUpdateOrErrorResponseWrapper {

        private AuthenticationTrustResolver trustResolver = new AuthenticationTrustResolverImpl();

        private final HttpServletRequest request;
        private final String token;
        private final RSAPrivateKey rSAPrivateKey;

        SaveToCookieResponseWrapper(HttpServletRequest request, HttpServletResponse response, String token, RSAPrivateKey rSAPrivateKey) {
            super(response, true);
            this.request = request;
            this.token = token;
            this.rSAPrivateKey = rSAPrivateKey;
        }

        @Override
        protected void saveContext(SecurityContext securityContext) {
            // log.info("SaveToCookieResponseWrapper saveContext");
            HttpServletResponse response = (HttpServletResponse) getResponse();
            Authentication authentication = securityContext.getAuthentication();
            if (authentication == null || trustResolver.isAnonymous(authentication)) {
                // log.info("SaveToCookieResponseWrapper saveContext true");
                response.addCookie(createExpireAuthenticationCookie(request));
                return;
            }
            Date expiresAt = new Date(System.currentTimeMillis() + 3600000);
            // log.info("SaveToCookieResponseWrapper " + authentication.getName());
            String jwt = null;
            try {
                jwt = Jwts.builder()
                        .signWith(SignatureAlgorithm.RS256, rSAPrivateKey)
                        .setSubject(authentication.getName())
                        .setExpiration(expiresAt).compact();
            } catch (Exception e) {
               log.info(e.getMessage());
            }
            response.addCookie(createAuthenticationCookie(jwt));
        }

        private Cookie createAuthenticationCookie(String cookieValue) {
            Cookie authenticationCookie = new Cookie(token, cookieValue);
            authenticationCookie.setPath("/");
            authenticationCookie.setHttpOnly(true);
            authenticationCookie.setSecure(request.isSecure());
            authenticationCookie.setMaxAge(3600000);
            return authenticationCookie;
        }

        private Cookie createExpireAuthenticationCookie(HttpServletRequest request) {
            Cookie removeSessionCookie = new Cookie(token, "");
            removeSessionCookie.setPath("/");
            removeSessionCookie.setMaxAge(0);
            removeSessionCookie.setHttpOnly(true);
            removeSessionCookie.setSecure(request.isSecure());
            return removeSessionCookie;
        }

    }
}

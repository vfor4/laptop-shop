package com.laptopshop.config;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.laptopshop.ulti.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;


public class SimpleAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		final UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();

		// String jwt = null;
		// try {
		// 	jwt = jwtTokenUtil.generateToken(userDetails);
		// } catch (NoSuchAlgorithmException e) {
		// 	e.printStackTrace();
		// }
		// System.out.println("request" + request.toString());
		// response.setHeader("accessToken", jwt);
		// response.setHeader("expirationTime", jwtTokenUtil.extractExpiration(jwt).toString());

		RequestDispatcher adminView = request.getRequestDispatcher("/WEB-INF/pages/admin/trangAdmin.jsp");
		RequestDispatcher homeView = request.getRequestDispatcher("/WEB-INF/pages/client/home.jsp");
		
		authorities.forEach(authority -> {
			// nếu quyền có vai trò user, chuyển đến trang "/" nếu login thành công
			if (authority.getAuthority().equals("ROLE_ADMIN") && !response.isCommitted()) {
				System.out.println("admin ne");
				try {
					// request.setAttribute("adminRequest", "abc");
					// response.setHeader("adminResponse", "abcresponse");
					redirectStrategy.sendRedirect(request, response, "/admin");
					// adminView.forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return;
			} else if (authority.getAuthority().equals("ROLE_SHIPPER") &&
					!response.isCommitted()) {
				try {
					redirectStrategy.sendRedirect(request, response, "/shipper");
				} catch (Exception e) {
					e.printStackTrace();
				}
				return;
			} else if (authority.getAuthority().equals("ROLE_MEMBER") &&
					!response.isCommitted()) {
				try {
					// homeView.forward(request, response);
					redirectStrategy.sendRedirect(request, response, "/");
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				throw new IllegalStateException();
			}
		});
		
	}

}

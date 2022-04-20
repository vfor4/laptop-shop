package com.laptopshop.config;

import com.laptopshop.config.stateless.JWTSecurityContextRepository;
import com.laptopshop.config.stateless.JwtCookieRequestCache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.savedrequest.RequestCache;

@Configuration
@EnableWebSecurity()
public class SecurityConfig extends WebSecurityConfigurerAdapter {



	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {

		builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public JWTSecurityContextRepository contextRepository(UserDetailsService userDetailsService,
			@Value("${auth.token}") String tokenName) {
		return new JWTSecurityContextRepository(userDetailsService, tokenName);
	}

	@Bean
	public SavedRequestAwareAuthenticationSuccessHandler authenticationSuccessHandler(RequestCache cache) {
		SavedRequestAwareAuthenticationSuccessHandler requestAwareAuthenticationSuccessHandler = 
		new SavedRequestAwareAuthenticationSuccessHandler();
		requestAwareAuthenticationSuccessHandler.setRequestCache(cache);

		return requestAwareAuthenticationSuccessHandler;
	}

	@Bean
	public JwtCookieRequestCache requestCache() {
		return new JwtCookieRequestCache();
	}

	
	@Bean
	public AuthenticationFailureHandler authenticationFailureHandler() {
		return new CustomAuthenticationFailureHandler();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		AuthenticationSuccessHandler successHandler = getApplicationContext()
				.getBean(AuthenticationSuccessHandler.class);

		JwtCookieRequestCache jwtCookieRequestCache = getApplicationContext().getBean(JwtCookieRequestCache.class);
		JWTSecurityContextRepository securityContextRepository = getApplicationContext()
				.getBean(JWTSecurityContextRepository.class);

		http.requestCache().requestCache(jwtCookieRequestCache);
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
				.securityContext().securityContextRepository(securityContextRepository)
			.and()
				.authorizeRequests().antMatchers("/register").permitAll()
				.antMatchers("/").permitAll()
				.antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/admin").hasRole("ADMIN")
				.antMatchers("/user/**").hasAnyRole("MEMBER", "ADMIN")
				.antMatchers("/api/gio-hang/**").permitAll()
				.antMatchers("/api/san-pham/latest").permitAll()
				.antMatchers("/api/danh-muc/allForReal").permitAll()
				.antMatchers("/api/tai-khoan/**").permitAll()
				.antMatchers("/api/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.POST, "/checkout").permitAll()
			.and()
				.formLogin().loginPage("/login").usernameParameter("email").passwordParameter("password")
				.successHandler(successHandler).permitAll()
				.failureHandler(authenticationFailureHandler())
			.and()
				.logout().logoutUrl("/logout").deleteCookies("auth-token").logoutSuccessUrl("/login?logout");
		// http.headers()
		// .xssProtection()
		// .and()
		// .contentSecurityPolicy("script-src 'self'");


		http.cors().and().csrf().disable();
		// .antMatchers(HttpMethod.POST, "/testThankYou").permitAll()
		// http.exceptionHandling().accessDeniedPage("/login?accessDenied");
		// .antMatchers("/shipper/**").hasRole("SHIPPER")
		// .csrf().csrfTokenRepository(new CookieCsrfTokenRepository())
		// .and().authorizeRequests().anyRequest().authenticated();
		// .rememberMe().key("uniqueAndSecret").rememberMeParameter("remember-me").and()

	}

}

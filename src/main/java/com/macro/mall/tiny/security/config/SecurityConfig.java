package com.macro.mall.tiny.security.config;

import com.macro.mall.tiny.security.component.JwtAuthenticationTokenFilter;
import com.macro.mall.tiny.security.component.RestAuthenticationEntryPoint;
import com.macro.mall.tiny.security.component.RestfulAccessDeniedHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author yangyonglong
 * @version 1.0
 * @className SecurityConfig
 * @date 1/21/21 10:34 AM
 **/
//@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		httpSecurity.csrf()
				.disable()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.authorizeRequests()
				.antMatchers(HttpMethod.GET,
						"/",
						"/*.html",
						"/favicon.ico",
						"/**/*.html",
						"/**/*.css",
						"/**/*.js",
						"/swagger-resources/**",
						"/v2/api-docs/**")
				.permitAll()
				.antMatchers("/admin/login", "/admin/register")
				.permitAll()
				.antMatchers(HttpMethod.OPTIONS)//跨域请求会先进行一次options请求
				.permitAll()
				.anyRequest()
				.authenticated();
		// 禁用缓存
		httpSecurity.headers().cacheControl();
		// 添加JWT filter
		httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
		//添加自定义未授权和未登录结果返回
		httpSecurity.exceptionHandling()
				.accessDeniedHandler(restfulAccessDeniedHandler())
				.authenticationEntryPoint(restAuthenticationEntryPoint());
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService())
				.passwordEncoder(passwordEncoder());
	}


	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter(){
		return new JwtAuthenticationTokenFilter();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	@Bean
	public RestfulAccessDeniedHandler restfulAccessDeniedHandler() {
		return new RestfulAccessDeniedHandler();
	}

	@Bean
	public RestAuthenticationEntryPoint restAuthenticationEntryPoint() {
		return new RestAuthenticationEntryPoint();
	}
}

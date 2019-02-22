package com.lgchem.cms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.lgchem.cms.handlers.CustomLoginSuccessHandler;
import com.lgchem.cms.login.service.CustomUserDetailsService;

@EnableWebSecurity
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
    
    @Autowired
    CustomUserDetailsService customUserDetailsService;
 
    static SessionRegistry SR;
    
    @Bean
    public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
    }
    
    @Bean
    public AuthenticationSuccessHandler successHandler() {
      return new CustomLoginSuccessHandler("/test");
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/openapi/**");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
        	.authorizeRequests()
        	.antMatchers( "/userReg").permitAll()
        	//.antMatchers( "/apis/**","/main","/test", "/index.jsp", "/home", "/favicon.ico", "/resources/**", "/publish/**").permitAll()
        	//.antMatchers("/rest/**", "/secure/**", "/manage/**", "/admin/**", "/comment/admin/**").hasAnyRole("1","2","3","4","5","6","7")
        		.anyRequest().authenticated()
        		.and()
        	.formLogin()
        		.successHandler(successHandler())
        		.and()
        	.logout()
        		.logoutUrl("/logout")
        		.logoutSuccessUrl("/home");
        
        http.sessionManagement()
            .invalidSessionUrl("/login") // 세선이 없으면 해당 URL로 이동시킨다.
            .sessionAuthenticationErrorUrl("/login") // 세션 인증 오류시 해당 URL로 이동
            .maximumSessions(1) // 동시 접속 1명
            .maxSessionsPreventsLogin(true) // session-management/concurrency-control@error-if-maximum-exceeded
            .expiredUrl("/expired-session") // session-management/concurrency-control@expired-url
            .sessionRegistry(SR); // session-management/concurrency-control@session-registry-ref
    }
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }
 
}
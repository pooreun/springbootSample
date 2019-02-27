package com.lgchem.cms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
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
      return new CustomLoginSuccessHandler("/cms/main");
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
    	//웹 리소스를 인증 해제 하는 로직을 넣자
    	// 메인페이지 : css나 js 같은것들도 여기에 포함시켜준다.
    	
        web.ignoring().antMatchers("/openapi/**","/js/**");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
        	.authorizeRequests()
        	.antMatchers( "/userReg","/cms/login","/cms/main","/js/**").permitAll()
        	//.antMatchers( "/apis/**","/main","/test", "/index.jsp", "/home", "/favicon.ico", "/resources/**", "/publish/**").permitAll()
        	//.antMatchers("/rest/**", "/secure/**", "/manage/**", "/admin/**", "/comment/admin/**").hasAnyRole("1","2","3","4","5","6","7")
        		.anyRequest().authenticated()
        		.and()
        	.formLogin()
        		//로그인 페이지 : 컨트롤러 매핑을 하지 않으면 기본 제공되는 로그인 페이지가 뜬다.
        		.loginPage("/cms/login")
        		.loginProcessingUrl("/cms/loginProcessing")
        		.usernameParameter("username")
        		.passwordParameter("password")
				//.successHandler(successHandler())
        		.successHandler((req,res,auth)->{    //Success handler invoked after successful authentication
        	    	for (GrantedAuthority authority : auth.getAuthorities()) {
        	    		System.out.println(authority.getAuthority());
        	    	}
        	    	System.out.println(auth.getName());
        	        res.sendRedirect("/cms/main"); // Redirect user to index/home page
        		})
        		.failureHandler((req,res,exp)->{  // Failure handler invoked after authentication failure
        	         String errMsg="";
        	         if(exp.getClass().isAssignableFrom(BadCredentialsException.class)){
        	            errMsg="Invalid username or password.";
        	         }else{
        	            errMsg="Unknown error - "+exp.getMessage();
        	         }
        	         req.getSession().setAttribute("message", errMsg);
        	         res.sendRedirect("/cms/login"); // Redirect user to login page with error message.
        	      })
        		.permitAll()
        		.and()
        	.logout()
        		.logoutUrl("/cms/logout")
        		.logoutSuccessUrl("/cms/login");
        
        http.sessionManagement()
            //.invalidSessionUrl("/login/loginForm") // 세선이 없으면 해당 URL로 이동시킨다.
            //.sessionAuthenticationErrorUrl("/login/loginForm") // 세션 인증 오류시 해당 URL로 이동
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
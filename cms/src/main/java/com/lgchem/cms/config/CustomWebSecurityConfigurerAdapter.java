package com.lgchem.cms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import com.lgchem.cms.handlers.CustomLoginSuccessHandler;
import com.lgchem.cms.login.service.CustomUserDetailsService;

@EnableWebSecurity
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
    
    @Autowired
    CustomUserDetailsService customUserDetailsService;
     
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
    	
        web.ignoring().antMatchers("/openapi/**","/js/**","/css/**");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
        	.authorizeRequests()
        	.antMatchers( "/userReg","/cms/login","/cms/main","/js/**","/index","/upload/**").permitAll()
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
				.successHandler(successHandler())
        		.failureHandler((req,res,exp)->{  // Failure handler invoked after authentication failure
        			String errMsg="";
        			if(exp.getClass().isAssignableFrom(BadCredentialsException.class)){
        				errMsg="Invalid username or password.";
        			}else{
        				//exp.getLocalizedMessage();
        				errMsg= exp.getMessage();
        			}
        			req.getSession().setAttribute("message", errMsg);
        			res.sendRedirect("/cms/login"); // Redirect user to login page with error message.
        		})
        		.permitAll()
        		.and()
        	.logout()
        		.logoutSuccessUrl("/cms/login")
                .invalidateHttpSession(true)
                .permitAll()
            .and()
	            .sessionManagement()
	            .invalidSessionUrl("/cms/login") // 세선이 없으면 해당 URL로 이동시킨다.
	            .sessionAuthenticationErrorUrl("/cms/login") // 세션 인증 오류시 해당 URL로 이동
	            .maximumSessions(3) // 동시 접속 1명
	            .maxSessionsPreventsLogin(true) // session-management/concurrency-control@error-if-maximum-exceeded
	            .expiredUrl("/expired-session") // session-management/concurrency-control@expired-url
	            .sessionRegistry(sessionRegistry());	//로그아웃 후 다시 로그인 하려하면 로그인 안되는 현상을 막기 위해 추가
        	
    }
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }
    
    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }
    
    @Bean
    public static ServletListenerRegistrationBean httpSessionEventPublisher() {
        return new ServletListenerRegistrationBean(new HttpSessionEventPublisher());
    }
    
    
}
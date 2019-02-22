package com.lgchem.cms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.navercorp.lucy.security.xss.servletfilter.XssEscapeServletFilter;

@SpringBootApplication
@MapperScan(basePackages = "com.lgchem.cms")
public class CmsApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(CmsApplication.class);
	}

	//@Bean
	//public FilterRegistrationBean xssEscapeServletFilter() {
	//	FilterRegistrationBean registrationBean = new FilterRegistrationBean();
	//	registrationBean.setFilter(new XssEscapeServletFilter());
	//	registrationBean.setOrder(1);
	//	registrationBean.addUrlPatterns("/*");
	//	return registrationBean;
	//}

	public static void main(String[] args) {
		SpringApplication.run(CmsApplication.class, args);
	}

}

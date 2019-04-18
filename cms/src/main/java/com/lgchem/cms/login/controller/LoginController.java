package com.lgchem.cms.login.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.lgchem.cms.login.domain.LoginVO;
import com.lgchem.cms.login.domain.Member;
import com.lgchem.cms.login.service.CustomUserDetailsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class LoginController {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	
	@RequestMapping("/")
	public void index(HttpServletRequest request, HttpServletResponse response) throws IOException {
		log.debug("테스트 입니다..");
		response.sendRedirect("/cms/main");
	}
	
	@RequestMapping(value = "/cms/login", method = RequestMethod.GET)
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/login/login");
		return mav;
	}

	@RequestMapping(value = "/cms/logout", method = RequestMethod.GET)
	public void logoutPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ModelAndView mav = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			log.info(auth.getName() + "( " + auth.getAuthorities() + ")" + "로그아웃 한다.");
			new SecurityContextLogoutHandler().logout(request, response, auth);
		} else {
			log.info("인증 정보가 없다");
		}
		//mav.setViewName("/login/login");
		//return mav;
		response.sendRedirect("/cms/login");
	}

	@RequestMapping(value = "/cms/main", method = RequestMethod.GET)
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();

		// Get authenticated user name from SecurityContext
		SecurityContext context = SecurityContextHolder.getContext();

		mav.addObject("message", "You are logged in as " + context.getAuthentication().getName());
		mav.setViewName("/main/main");
		return mav;
	}

	@RequestMapping("/cms/test")
	public String test() {
		log.debug("테스트 입니다..");
		return "This is spring";
	}

	@RequestMapping(value = "/cms/json", method = RequestMethod.POST)
	public @ResponseBody LoginVO json(@RequestBody LoginVO json) {
		log.debug("TestForm : {}", json);

		return json;
	}

	@RequestMapping("/cms/userReg")
	public String userReg() {
		Member member = new Member();
		member.setUsername("poo9901");
		member.setPassword("123456");
		member.setAccountNonExpired(true);
		member.setAccountNonLocked(true);
		member.setName("USER1");
		member.setCredentialsNonExpired(true);
		member.setEnabled(true);
		member.setAuthorities(AuthorityUtils.createAuthorityList("USER"));

		customUserDetailsService.createUser(member);

		return "성공";
	}

}

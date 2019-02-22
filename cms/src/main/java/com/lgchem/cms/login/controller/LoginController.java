package com.lgchem.cms.login.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.lgchem.cms.login.domain.LoginVO;
import com.lgchem.cms.login.service.LoginService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("login")
public class LoginController {

	@Resource
	private LoginService loginservice;
	
	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public @ResponseBody LoginVO login(HttpServletRequest request, HttpServletResponse response) {

		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		
		log.info("ddddd = " + userid);
		
		LoginVO member = new LoginVO();
		member.setUserId(userid);
		member.setPassword(password);
		
		LoginVO loginVO = loginservice.login(member);
		
		log.info("id = " + loginVO.getUserId());
		log.info("pw = " + loginVO.getPassword());
				
		return loginVO;
	}

	@RequestMapping("test")
	public String test() {
		log.debug("�뀒�뒪�듃�엯�땲�떎.");
		return "This is spring";
	}
	
	
	@RequestMapping(value = "/json", method = RequestMethod.POST)
	public @ResponseBody LoginVO json(@RequestBody LoginVO json) {
		log.debug("TestForm : {}", json);

		return json;
	}

}

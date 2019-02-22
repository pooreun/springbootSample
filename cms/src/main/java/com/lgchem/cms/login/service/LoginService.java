package com.lgchem.cms.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lgchem.cms.login.domain.LoginVO;
import com.lgchem.cms.login.mapper.LoginMapper;

@Service
public class LoginService implements UserDetailsService{
	
	@Autowired
	LoginMapper loginMapper;
	
	public LoginVO login(LoginVO loginVO) {
		return loginMapper.login(loginVO);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
}

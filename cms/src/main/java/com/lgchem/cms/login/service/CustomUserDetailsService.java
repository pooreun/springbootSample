package com.lgchem.cms.login.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lgchem.cms.login.domain.Member;
import com.lgchem.cms.login.domain.SecurityMember;
import com.lgchem.cms.login.mapper.UserMapper;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private static final String ROLE_PREFIX = "ROLE_";

	@Autowired
	UserMapper userMapper;

	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Member member = userMapper.readUser(username);
		if (member != null) {
			member.setAuthorities(makeGrantedAuthority(userMapper.readAuthority(username)));
		}
		return new SecurityMember(member);
	}

	static List<GrantedAuthority> makeGrantedAuthority(List<String> roles) {
		List<GrantedAuthority> list = new ArrayList<>();
		roles.forEach(role -> list.add(new SimpleGrantedAuthority(ROLE_PREFIX + role)));
		return list;
	}

	public PasswordEncoder passwordEncoder() {
		return this.passwordEncoder;
	}

	public void createUser(Member member) {
		String rawPassword = member.getPassword();
		String encodedPassword = new BCryptPasswordEncoder().encode(rawPassword);
		member.setPassword(encodedPassword);
		userMapper.createUser(member);
		userMapper.createAuthority(member);
	}
	
	public void updateUser(Member member) {
		userMapper.createUser(member);
	}

	public void deleteUser(String username) {
		userMapper.deleteUser(username);
		userMapper.deleteAuthority(username);
	}

}

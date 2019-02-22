package com.lgchem.cms.login.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.GrantedAuthority;

import com.lgchem.cms.login.domain.Member;
import com.lgchem.cms.login.domain.User;

@Mapper	
public interface UserMapper {
	public Member readUser(String username);
    public List<String> readAuthority(String username);
    public void createUser(User user);
    public void createAuthority(User user);
    public void deleteUser(String username);
    public void deleteAuthority(String username);
}

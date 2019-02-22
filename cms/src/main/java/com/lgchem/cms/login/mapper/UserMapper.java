package com.lgchem.cms.login.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lgchem.cms.login.domain.Member;

@Mapper	
public interface UserMapper {
	public Member readUser(String username);
    public List<String> readAuthority(String username);
    public void createUser(Member user);
    public void createAuthority(Member user);
    public void deleteUser(String username);
    public void deleteAuthority(String username);
}

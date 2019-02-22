package com.lgchem.cms.login.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.lgchem.cms.login.domain.LoginVO;

@Repository
@Mapper
public interface LoginMapper {
	
	public LoginVO login(LoginVO loginVO);
}

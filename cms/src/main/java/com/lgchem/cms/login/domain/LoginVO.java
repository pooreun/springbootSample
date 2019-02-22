package com.lgchem.cms.login.domain;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Alias("loginVO")
@JsonDeserialize
@NoArgsConstructor
@ToString
public class LoginVO {
	
	private String userId;
	private String password;
	private String name;
}

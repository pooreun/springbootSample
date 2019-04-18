package com.lgchem.cms.template.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("templateVO")
public class TemplateVO {
	
	private int idx;
	private String html;
	private String css;
}

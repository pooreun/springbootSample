package com.lgchem.cms.template.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.lgchem.cms.template.domain.TemplateVO;

@Mapper
public interface TemplateMapper {

	public void insertTemplate(TemplateVO templateVO);
	
	public TemplateVO selectTemplate(int id);
}

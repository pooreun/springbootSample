package com.lgchem.cms.template.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgchem.cms.template.domain.TemplateVO;
import com.lgchem.cms.template.mapper.TemplateMapper;

@Service
public class TemplateService {
	
	@Autowired
	TemplateMapper templateMapper;

	public void insertTemplate(TemplateVO templateVO) {
		templateMapper.insertTemplate(templateVO);
	}
	
	public TemplateVO selectTemplate(int id){
		return templateMapper.selectTemplate(id);
	}
	
}

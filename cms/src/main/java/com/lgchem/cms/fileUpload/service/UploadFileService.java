package com.lgchem.cms.fileUpload.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgchem.cms.fileUpload.domain.ImageVO;
import com.lgchem.cms.fileUpload.mapper.UploadFileMapper;

@Service
public class UploadFileService {
	
	@Autowired
	UploadFileMapper uploadFileMapper;
		
	public List<ImageVO> selectImage() {
		return uploadFileMapper.selectImage();
	}

	public void insertImage(ImageVO imageVO) {
		uploadFileMapper.insertImage(imageVO);
	}
}

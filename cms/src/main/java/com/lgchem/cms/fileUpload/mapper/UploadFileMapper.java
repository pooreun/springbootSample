package com.lgchem.cms.fileUpload.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lgchem.cms.fileUpload.domain.ImageVO;

@Mapper
public interface UploadFileMapper {

	public void insertImage(ImageVO imageVO);
	
	public List<ImageVO> selectImage();
}

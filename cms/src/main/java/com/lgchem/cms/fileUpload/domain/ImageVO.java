package com.lgchem.cms.fileUpload.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("imageVO")
public class ImageVO {
	
	private String name;
	private String type;
	private String src;
	private String height;
	private String width;
}

package com.lgchem.cms.template.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.text.StringEscapeUtils;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lgchem.cms.fileUpload.domain.ImageVO;
import com.lgchem.cms.fileUpload.service.UploadFileService;
import com.lgchem.cms.template.domain.TemplateVO;
import com.lgchem.cms.template.service.TemplateService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/template")
public class TemplateController {
	
	@Autowired
	private TemplateService templateService;
	
	@Autowired
	private UploadFileService uploadFileService;
	
	@RequestMapping(value = "/temp")
	public ModelAndView grapesjs(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		
		// Get authenticated user name from SecurityContext
		SecurityContext context = SecurityContextHolder.getContext();

		mav.addObject("message", "You are logged in as " + context.getAuthentication().getName());
		mav.setViewName("/template/temp");
		return mav;
	}
	
	@RequestMapping(value = "/webbuilder")
	public ModelAndView webbuild(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		
		// Get authenticated user name from SecurityContext
		SecurityContext context = SecurityContextHolder.getContext();

		mav.addObject("message", "You are logged in as " + context.getAuthentication().getName());
		mav.setViewName("/template/webbuilder");
		return mav;
	}
	
	@RequestMapping(value = "/loadHtmlCss", method = RequestMethod.GET)
	public @ResponseBody String loadHtmlCss(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, JsonProcessingException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		TemplateVO templateVO = templateService.selectTemplate(id);
		String imageJson = "[]";
		
		List<ImageVO> imageVO = uploadFileService.selectImage();
		if(imageVO.size() > 0) {
			imageJson = new ObjectMapper().writeValueAsString(imageVO);
		}
						
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("gjs-html", StringEscapeUtils.unescapeHtml4(templateVO.getHtml()));
		jsonObject.put("gjs-css", StringEscapeUtils.unescapeHtml4(templateVO.getCss()));
		jsonObject.put("gjs-assets", imageJson);
		
		String jsonInfo = jsonObject.toJSONString();
        return jsonInfo;
	}

	@RequestMapping(value = "/saveHtmlCss", method = RequestMethod.POST)
	public @ResponseBody String saveHtmlCss(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		
		String now_address = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
    	
		String css = StringEscapeUtils.unescapeHtml4(request.getParameter("css").toString());

		String html = "<!doctype html><html lang=\"en\">\r\n";
		html += "<head>\r\n";
		html += "<meta charset=\"EUC-KR\">\r\n";
		html += "<link rel=\"stylesheet\" href='css/style.css'></style>\r\n";
		html += "<link href=\"https://fonts.googleapis.com/css?family=Roboto\" rel=\"stylesheet\">\r\n";
		html += "<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/icon?family=Material+Icons\">\r\n";
		html += "<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n";
		//html += "<link rel=\"stylesheet\" href=\""+now_address+"/css/materialize/materialize.min.css\">";
		//html +="<script src=\""+now_address+"/js/jquery-3.3.1.min.js\"></script>";
		//html +="<script src=\""+now_address+"/js/materialize/materialize.min.js\"></script>";
		html += "<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css\">\r\n";
		html += "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\r\n";
		html += "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js\"></script>\r\n";
		
		html += "</head>\r\n";
		html += "<body>\r\n";
		html += StringEscapeUtils.unescapeHtml4(request.getParameter("html").toString()); 
		html += "</body>\r\n";
		html += "</html>";
				
		File htmlFile = new File("d:\\html\\index.html");
		File cssFile = new File("d:\\html\\css\\style.css");
		try {
			// 파일에 문자열을 쓴다.
			// 하지만 이미 파일이 존재하면 모든 내용을 삭제하고 그위에 덮어쓴다
			// 파일이 손산될 우려가 있다.
			FileWriter fw = new FileWriter(htmlFile);
			fw.write(html);
			fw.close();
			
			fw = new FileWriter(cssFile);
			fw.write(css.replace("}", "}\r\n"));
			fw.close();
			
			TemplateVO templateVO = new TemplateVO();
			templateVO.setHtml(request.getParameter("html").toString());
			templateVO.setCss(request.getParameter("css").toString());
			
			templateService.insertTemplate(templateVO);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "susses";
	}
}

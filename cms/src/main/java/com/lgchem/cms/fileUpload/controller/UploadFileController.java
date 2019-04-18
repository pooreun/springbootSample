package com.lgchem.cms.fileUpload.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lgchem.cms.fileUpload.domain.ImageVO;
import com.lgchem.cms.fileUpload.service.UploadFileService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/upload")
public class UploadFileController {
	
	public static String UPLOAD_DIR = "/upload/image/";
    public static String UPLOAD_DIR_PATH;
    
    @Autowired
    private UploadFileService uploadFileService; 
	
	@RequestMapping(method = RequestMethod.GET, value = "/files")
    public String provideUploadInfo(Model model, HttpServletRequest request) {
		
		String pathSet =  request.getSession().getServletContext().getRealPath("") + UPLOAD_DIR ;
		
        File rootFolder = new File(pathSet);

        List<String> fileNames = Arrays.stream(rootFolder.listFiles())
                .map(f -> f.getName())
                .collect(Collectors.toList());

        model.addAttribute("files",
            Arrays.stream(rootFolder.listFiles())
                .sorted(Comparator.comparingLong(f -> -1 * f.lastModified()))
                .map(f -> f.getName())
                .collect(Collectors.toList())
        );

        return "upload_result";
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "/single_upload")
    public String fileUpload(@RequestParam("name") String name,
                             @RequestParam("file") MultipartFile file,
                             RedirectAttributes redirectAttributes) {
		
		log.info("upload 시작");
        if (name.contains("/")) {
            redirectAttributes.addFlashAttribute("message", "Folder separators not allowed");
            return "redirect:/files";
        }
        if (name.contains("/")) {
            redirectAttributes.addFlashAttribute("message", "Relative pathnames not allowed");
            return "redirect:/files";
        }

        if (!file.isEmpty()) {
            try {
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(new File(UPLOAD_DIR + "/" + name)));
                FileCopyUtils.copy(file.getInputStream(), stream);
                stream.close();
                redirectAttributes.addFlashAttribute("message",
                        "You successfully uploaded " + name + "!");
            }
            catch (Exception e) {
                redirectAttributes.addFlashAttribute("message",
                        "You failed to upload " + name + " => " + e.getMessage());
            }
        }
        else {
            redirectAttributes.addFlashAttribute("message",
                    "You failed to upload " + name + " because the file was empty");
        }

        return "redirect:/files";
    }

    @RequestMapping(value="/multi_upload_form", method=RequestMethod.GET)
    public String showMultiUploadForm() {
        return "multi_upload_form";
    }

    @RequestMapping(value="/single_upload_form", method = RequestMethod.GET)
    public String singleUploadForm() {
        return "single_upload_form";
    }

    /**
     *
     * http://www.concretepage.com/spring-4/spring-4-mvc-single-multiple-file-upload-example-with-tomcat
     * @throws IOException 
     * @throws IllegalStateException 
     */
    @RequestMapping(value="/multi_upload_image", method=RequestMethod.POST )
    public @ResponseBody
    String multipleSave(@RequestParam("file") MultipartFile[] files, HttpServletRequest request) throws IllegalStateException, IOException{
    	
    	log.info("upload multipleSave 시작");
    	String now_address = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
    	String pathSet =  request.getSession().getServletContext().getRealPath("") + UPLOAD_DIR ;
    	
    	File f = new File(pathSet);
        f.mkdir();
        UPLOAD_DIR_PATH = f.getAbsolutePath();

        
        JSONObject jsonObject = new JSONObject();
        JSONArray imageArray = new JSONArray();
        
        if (files != null && files.length >0) {
        	
        	for(MultipartFile uploadedFile : files) {
                JSONObject imageInfo = new JSONObject();
                File file = new File(pathSet + uploadedFile.getOriginalFilename());
                uploadedFile.transferTo(file);
                
                imageInfo.put("name", file.getName());
                imageInfo.put("type", "image");
                
                imageInfo.put("src", now_address+"/upload/image/" + file.getName());
                imageInfo.put("height", "350");
                imageInfo.put("width", "250");
                
                ImageVO imageVO = new ImageVO();
                imageVO.setName(file.getName());
                imageVO.setType("image");
                imageVO.setSrc(now_address+"/upload/image/" + file.getName());
                imageVO.setHeight("350");
                imageVO.setWidth("250");
                
                uploadFileService.insertImage(imageVO);
                
                imageArray.add(imageInfo);
            }
        	
        	jsonObject.put("data", imageArray);
        	String jsonInfo = jsonObject.toJSONString();
            return jsonInfo;
        } else {
        	log.info("Unable to upload. File is empty.");
            return "Unable to upload. File is empty.";
        }
    }
}

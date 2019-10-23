package com.test.web;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.test.dto.FileUploadDTO;

@Controller
public class FileUploadController {
	@RequestMapping("/file/upload")
	@ResponseBody
private FileUploadDTO Fileupload(@RequestParam(required=false,name="editormd-image-file")MultipartFile editormd_image_files) throws IllegalStateException, IOException{
		 FileUploadDTO file2 = null;
		if(editormd_image_files!=null){
			String oldFilename = editormd_image_files.getOriginalFilename();
		    String substring = oldFilename.substring( oldFilename.lastIndexOf("."));
		    String uuid=UUID.randomUUID().toString().replaceAll("-", "");
		    //要使用绝对路径才行
			String realPath ="/img";//获取本地存储位置的绝对路径
		    String newfile=realPath+"/"+uuid+substring;
		    File file=new File(newfile);		  
		    file2=new FileUploadDTO();
			file2.setSuccess(1);
			file2.setUrl(newfile);
		    }	
	return file2;
	
	
}
}

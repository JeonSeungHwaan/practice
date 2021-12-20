package org.mvc.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/file/")
public class FileUploadController {
	
	private static int count = 0;
	
	@RequestMapping("fileUpload")
	public String fileUpload() {
		return "file/fileUpload";
	}
	
	@RequestMapping("fileUploadPro")
	public String fileUploadPro(Model model, String name, MultipartFile file) {
		String fileName = file.getOriginalFilename();
		String type = fileName.split("/")[0];
		
		if(type.equals("image")) {
			File folder = new File("E://fileSave/");
			String [] folderList = folder.list();
			
			for(String orgName : folderList) {
				if(orgName.equals(fileName)) {
					fileName = (++count) + fileName;
				}
			}
		}
		File f = new File("E://fileSave/"+fileName);
		
		try {
			file.transferTo(f);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		// view로 값을 전달할 땐 model.addAttribute를 작성해야함
		model.addAttribute("name", name);
		model.addAttribute("file", fileName);
		
		return "/file/fileUploadPro";
	}
}

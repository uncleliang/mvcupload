package com.niit.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	@RequestMapping("goUpload")
	public String goUpload() {
		return "upload";
	}
	
	@RequestMapping("uploadFile")
	public String uploadFile(
			@RequestParam("name")String name,
			@RequestParam("file")MultipartFile file)
					throws IllegalStateException, IOException {
		System.out.println("文件上传方法开始.....");
		System.out.println(name);
		String root = "F:\\files\\";
		String path = file.getOriginalFilename();
		
		if(!file.isEmpty()) {
			file.transferTo(new File(root+path));
		}
		System.out.println("文件上传方法结束.....");
		return "redirect:goUpload"; // @RequestMapping("goUpload")
	}
	
	@RequestMapping("/download/{fileName:\\w+}{fileType:\\.[a-z]+}")
	public ResponseEntity<byte[]> download(
			@PathVariable("fileName") String fileName,
			@PathVariable("fileType") String fileType) 
					throws IOException {
		String root = "F:\\files\\";
		byte[] data=null;
		
		File file = new File(root+fileName+fileType);
		
		// 字节流 读取对象
		FileInputStream in = new FileInputStream(file);
		
		data = new byte[in.available()];
		// 读取文件 存入 数据
		in.read(data);
		in.close();
		
		HttpHeaders headers = new HttpHeaders();
	    headers.add("Content-Disposition", "attchement;filename=" + file.getName());
	    HttpStatus statusCode = HttpStatus.OK;
	     
	    ResponseEntity<byte[]> entity = 
	    		new ResponseEntity<byte[]>(data, headers, statusCode);
	    return entity;
	}
}

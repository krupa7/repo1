package com.nuvizz.maven.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.nuvizz.maven.dto.LoginDTO;
import com.nuvizz.maven.dto.RegistrationDTO;
import com.nuvizz.maven.service.LoginServiceImpl;
import com.sun.org.apache.regexp.internal.recompile;

@Component
@RequestMapping("/")
public class FileUploadController {


	@Autowired
	LoginServiceImpl impl;
	
	@RequestMapping("/upload.do")
	public String upload(@RequestParam CommonsMultipartFile file,
			@ModelAttribute LoginDTO dto, HttpServletRequest request) {
		// String path=session.getServletContext().getRealPath("/");
		String path = "C:/Users/khnaik/Documents/Upload";

		System.out.println("path" + path);
		String filename = file.getOriginalFilename();
		String fileString = path + "/" + filename;
		System.out.println(fileString);
		boolean res=false;
		try {
			byte barr[] = file.getBytes();

			BufferedOutputStream bout = new BufferedOutputStream(
					new FileOutputStream(path + "/" + filename));
			bout.write(barr);
			bout.flush();
			bout.close();

			HttpSession session = request.getSession(false);
			RegistrationDTO dto2 = (RegistrationDTO) session.getAttribute("obj1");
			dto.setUserId(dto2.getFname());
			dto.setPassword(dto2.getPassword());

			dto.setFilePath(fileString);
			res=impl.saveFileService(dto);
			
			if(res)
				return "/Success.jsp";
			else
				return "/Fail.jsp";

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}

package com.nuvizz.maven.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nuvizz.maven.dto.LoginDTO;
import com.nuvizz.maven.dto.RegistrationDTO;
import com.nuvizz.maven.service.LoginServiceImpl;
import com.sun.istack.internal.logging.Logger;

@Component
@RequestMapping("/")
public class LoginController {

	

	public LoginController() {
		System.out.println(this.getClass().getSimpleName() + " created!!");

	}

	@Autowired
	private LoginServiceImpl impl;

	@RequestMapping("/welcome.do")
	public String welcome(HttpServletRequest request) {
		System.out.println("inside welcome !!");
		return "/Login.jsp";
	}

	@RequestMapping("/login.do")
	public String login(@ModelAttribute LoginDTO dto, HttpServletRequest request) {

		System.out.println("Starting login Controller");

		try {

			HttpSession session = null;

			RegistrationDTO dto2 = impl.loginService(dto);

			if (dto2 != null) {
				if (dto2.isStatus()) {

					session = request.getSession(true);
					session.setAttribute("obj1", dto2);
					return "/UploadFile.jsp";
				} else
					return "/Disable.jsp";
			} else {
				return "/Fail.jsp";

			}
		} catch (Exception e) {
			System.err.println("Exception in login Controller " + e);
			e.printStackTrace();
		}

		System.out.println("Ending login Controller");
		return null;

	}
}

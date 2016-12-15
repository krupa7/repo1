package com.nuvizz.maven.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nuvizz.maven.dao.LoginDAOImpl;
import com.nuvizz.maven.dto.LoginDTO;
import com.nuvizz.maven.dto.RegistrationDTO;


@Component
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDAOImpl dao;
	
	public LoginServiceImpl() {
		System.err.println("login service created..");
	}
	

	public RegistrationDTO loginService(LoginDTO dto) {
		System.out.println("Starting login Service");

		RegistrationDTO dto2 = null;
		try {
			if (dto.getUserId() != null && dto.getPassword() != null) {
				System.out.println("Username and password found");
				dto2=dao.authenticateUser(dto);
				return dto2;
			} else {
				System.out.println("username & password not found");
			}
		} catch (Exception e) {
			System.err.println("Exception in service state " + e);
			e.printStackTrace();
		}

		System.out.println("Ending login Service");

		return dto2;

	}
	
	public boolean saveFileService(LoginDTO dto) {
		System.out.println("Starting file save Service");
		boolean res = false;
		if (dto != null) {
			try {
				res = dao.saveLoginDTO(dto);
			} catch (Exception e) {
				System.err.println("Exception in saving file service " + e);
				e.printStackTrace();
			}
		}

		System.out.println("Ending file save Service");

		return res;
	}

}

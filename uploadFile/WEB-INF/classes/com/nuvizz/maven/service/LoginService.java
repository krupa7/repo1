package com.nuvizz.maven.service;

import com.nuvizz.maven.dto.LoginDTO;
import com.nuvizz.maven.dto.RegistrationDTO;



public interface LoginService {
	RegistrationDTO loginService(LoginDTO dto);

}

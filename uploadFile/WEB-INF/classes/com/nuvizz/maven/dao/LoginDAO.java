package com.nuvizz.maven.dao;

import com.nuvizz.maven.dto.LoginDTO;
import com.nuvizz.maven.dto.RegistrationDTO;



public interface LoginDAO {
	RegistrationDTO authenticateUser(LoginDTO dto);
	
}

package com.nuvizz.rest.service;

import java.util.List;

import com.nuvizz.rest.dto.PersonDTO;

public interface PersonService {
	boolean savepersonservice(PersonDTO dto);
	List<PersonDTO> fetchallService();
}

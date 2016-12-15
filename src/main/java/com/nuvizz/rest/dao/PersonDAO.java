package com.nuvizz.rest.dao;

import java.util.List;

import com.nuvizz.rest.dto.PersonDTO;

public interface PersonDAO {
	boolean savePerson(PersonDTO dto);
	List<PersonDTO> fetchAll();
}

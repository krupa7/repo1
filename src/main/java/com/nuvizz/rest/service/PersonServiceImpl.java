package com.nuvizz.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nuvizz.rest.dao.PersonDAOImpl;
import com.nuvizz.rest.dto.PersonDTO;

@Component
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDAOImpl dao;

	public boolean savepersonservice(PersonDTO dto) {
		System.out.println("Starting person Service");
		boolean res = false;
		if (dto != null) {
			try {
				res = dao.savePerson(dto);
			} catch (Exception e) {
				System.err.println("Exception in person service " + e);
				e.printStackTrace();
			}
		}

		System.out.println("Ending person Service");

		return res;
	}

	public List<PersonDTO> fetchallService() {
		System.out.println("Starting read Service");
		List<PersonDTO> list = null;

		try {
			list = dao.fetchAll();
		} catch (Exception e) {
			System.err.println("Exception in person service " + e);
			e.printStackTrace();
		}

		System.out.println("Ending read Service");

		return list;
	}
}

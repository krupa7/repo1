package com.nuvizz.rest.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nuvizz.rest.dto.PersonDTO;

@Component
public class PersonDAOImpl implements PersonDAO {

	@Autowired
	private SessionFactory factory;

	public boolean savePerson(PersonDTO dto) {
		System.out.println("Starting person DAO");
		boolean res = false;
		if (dto != null) {

			Session s = null;
			Transaction t = null;

			try {
				s = factory.openSession();
				t = s.beginTransaction();
				s.save(dto);
				t.commit();
				res = true;
			} catch (HibernateException he) {
				t.rollback();
				System.err.println("Exception " + he.getMessage());
				he.printStackTrace();
			} finally {
				s.close();
			}

		}

		System.out.println("Ending person DAO");
		return res;

	}

	public List<PersonDTO> fetchAll() {
		System.out.println("Starting read DAO");
		List<PersonDTO> list = null;

		Session s = null;
		Transaction t = null;

		try {
			s = factory.openSession();
			t = s.beginTransaction();
			String str = "from PersonDTO p";
			Query query = s.createQuery(str);
			list = query.list();

			t.commit();
			s.close();
		} catch (HibernateException he) {

			System.err.println("Exception " + he.getMessage());
			he.printStackTrace();
		}

		System.out.println("Ending read DAO");
		return list;

	}

}

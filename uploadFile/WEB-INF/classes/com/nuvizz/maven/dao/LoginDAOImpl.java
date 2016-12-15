package com.nuvizz.maven.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nuvizz.maven.dto.LoginDTO;
import com.nuvizz.maven.dto.RegistrationDTO;
import com.nuvizz.maven.util.AESCrypt;


@Component
public class LoginDAOImpl implements LoginDAO {
	
	

	
	@Autowired
	private SessionFactory factory;
	
	
	public LoginDAOImpl() {
		System.out.println("login dao created...");
	}

	
	public RegistrationDTO authenticateUser(LoginDTO dto) {

		System.out.println("Inside login dao");
		
	
		RegistrationDTO fromDB = null;

		if (dto != null) {
			String pass=dto.getPassword();
			String encry=AESCrypt.encrypt(pass);

			Session session = null;
			try {
				session = factory.openSession();

				String s1 = "select reg from RegistrationDTO reg where reg.fname=:nm and reg.password=:pass";
				//logger.info(dto.getUserId());
				//logger.debug(dto.getPassword());
				Query q = session.createQuery(s1);
				q.setParameter("nm", dto.getUserId());
				q.setParameter("pass", encry);
				fromDB = (RegistrationDTO) q.uniqueResult();
				System.out.println(fromDB);
				return fromDB;

			} catch (HibernateException he) {
				System.err.println("Exception " + he.getMessage());
				he.printStackTrace();
			} finally {
				session.close();
			}
		}
		System.out.println("exiting login dao");

		return fromDB;
	}

	public boolean saveLoginDTO(LoginDTO dto) {
		System.out.println("Starting save file DAO");
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

		System.out.println("Ending file upload DAO");
		return res;

	}
	
}

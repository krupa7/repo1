package com.nuvizz.rest.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="person")
public class PersonDTO implements Serializable {

	@Id
	@GenericGenerator(name="auto",strategy="increment")
	@GeneratedValue(generator="auto")
	@Column(name="p_id")
	private int id;
	@Column(name="p_name")
	private String name;
	@Column(name="p_email")
	private String email;

	public PersonDTO() {
		System.out.println(this.getClass().getSimpleName() + " created!!!");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "PersonDTO [name=" + name + ", email=" + email + "]";
	}
	
	
}

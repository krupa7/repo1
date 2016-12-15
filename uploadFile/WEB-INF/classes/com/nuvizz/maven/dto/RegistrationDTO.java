package com.nuvizz.maven.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.common.util.impl.LoggerFactory;

import com.sun.istack.internal.logging.Logger;

@Entity
@Table(name = "regi")
public class RegistrationDTO implements Serializable{
	
	
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="u_id")
		private int uid;
		@Column(name = "f_name")
		private String fname;
		@Column(name = "l_name")
		private String lname;
		@Column(name = "email")
		private String email;
		@Column(name = "ph_no")
		private long phoneNum;
		@Column(name = "password")
		private String password;
		@Column(name = "c_password")
		private String cpass;
		@Column(name="status")
		private boolean status;
		

		public RegistrationDTO() {
			System.out.println(this.getClass().getSimpleName()+" created");
		}


		@Override
		public String toString() {
			return "RegistrationDTO [uid=" + uid + ", fname=" + fname
					+ ", lname=" + lname + ", email=" + email + ", phoneNum="
					+ phoneNum + "]";
		}


		public int getUid() {
			return uid;
		}


		public void setUid(int uid) {
			this.uid = uid;
		}


		public String getFname() {
			return fname;
		}


		public void setFname(String fname) {
			this.fname = fname;
		}


		public String getLname() {
			return lname;
		}


		public void setLname(String lname) {
			this.lname = lname;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public long getPhoneNum() {
			return phoneNum;
		}


		public void setPhoneNum(long phoneNum) {
			this.phoneNum = phoneNum;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public boolean isStatus() {
			return status;
		}


		public void setStatus(boolean status) {
			this.status = status;
		}


		public String getCpass() {
			return cpass;
		}


		public void setCpass(String cpass) {
			this.cpass = cpass;
		}


}

package com.capgemini.cabbookingapplication.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * This class is for storing admin information
 */
@Entity
public class Admin extends AbstractUser {

	/*
	 * this is primary key for admin table
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;

	public Admin() {
		super();
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

}

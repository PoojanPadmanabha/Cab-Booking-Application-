package com.capgemini.cabbookingapplication.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/*
 * This is class will save all the data for user, it will be parent class
 */
@MappedSuperclass
public class AbstractUser {

	/*
	 * This is username
	 */
	@Column(unique= true, updatable=false)
	@NotBlank(message = "Username cannot be blank")
	private String username;
	
	/*
	 * this is password used for login
	 */
	@NotBlank(message="Password is required")
	@Size(min = 8, max=15, message="Size must be between 8 and 15")
	@Column(unique= true)
	private String password;
	
	/*
	 * this is address
	 */
	private String address;
	
	/*
	 * This is mobile number of the user
	 */
	@NotBlank(message="Mobile number is required")
	@Size(min = 10, message="Size must be greater than and equal to 10")
	private String mobileNumber;
	
	/*
	 * user mail id
	 */
	@Column(unique=true)
	@NotBlank(message="Email is required")
	private String email;
	public AbstractUser() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}

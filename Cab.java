package com.capgemini.cabbookingapplication.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*
 * This is cab class for storing cab details
 */
@Entity
public class Cab extends AbstractUser {

	/*
	 * this is primary key for cab table
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cabId;

	/*
	 * this is for storing car type like premium , mini, prime and cannot be null
	 */

	@NotBlank(message = "Car type is required")
	private String carType;

	/*
	 * this the rate for cab
	 */
	@NotBlank(message = "Km per rate is required")
	private float perKmRate;
	
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="driverId", nullable = false)
	@JsonIgnore
	private Driver driver;

	public Cab() {
		super();
	}

	public int getCabId() {
		return cabId;
	}

	public void setCabId(int cabId) {
		this.cabId = cabId;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public float getPerKmRate() {
		return perKmRate;
	}

	public void setPerKmRate(float perKmRate) {
		this.perKmRate = perKmRate;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	

}

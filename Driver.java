package com.capgemini.cabbookingapplication.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;


/*
 * this is customer class for saving driver information
 */
@Entity
public class Driver extends AbstractUser {

	/*
	 * this is primary key for driver table
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int driverId;

	/*
	 * this is driver license no and is required
	 */
	@NotBlank(message = "License no is required")
	private String licenseNo;

	/*
	 * this is cab object
	 */
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "driver")
	private Cab cab;

	/*
	 * this the rating of driver
	 */
	private float rating;

	/*
	 * this is list of TripBooking object having a one to many relation
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "backlog")
	private List<TripBooking>tripBooking = new ArrayList<>();

	

	public Driver() {
		super();
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public Cab getCab() {
		return cab;
	}

	public void setCab(Cab cab) {
		this.cab = cab;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public List<TripBooking> getTripBooking() {
		return tripBooking;
	}

	public void setTripBooking(List<TripBooking> tripBooking) {
		this.tripBooking = tripBooking;
	}

	
}

package com.capgemini.cabbookingapplication.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/*
 * this is customer class for saving customer information
 */
@Entity
public class Customer extends AbstractUser {

	/*
	 * this is primary key for customer table
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;

	/*
	 * one to one relation with tripbooking class
	 */
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "customer")
	private TripBooking tripBooking;

	public Customer() {
		super();
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public TripBooking getTripBooking() {
		return tripBooking;
	}

	public void setTripBooking(TripBooking tripBooking) {
		this.tripBooking = tripBooking;
	}

}

package com.capgemini.cabbookingapplication.domain;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class TripBooking {
	@Id
	private int tripBookingId;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="customerId", nullable = false)
	@JsonIgnore
	private Customer customer;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "driverId", updatable = false, nullable = false)
	@JsonIgnore
	private Driver driver;
	
	private String fromLocation;

	private String toLocation;

	private LocalDateTime fromDateTime;
	
	private LocalDateTime toDateTime;
	
	private boolean status;

	/*
	 * this is distance between to and from location
	 */
	private float distanceInKm;

	/*
	 * this is bill calculated ie. distance multiply by perKmRate
	 */
	private float bill;

}

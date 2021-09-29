package com.capgemini.cabbookingapplication.domain;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*
 * this is customer class for saving trip booking information
 */
@Entity
public class TripBooking {

	/*
	 * this is primary key for driver table
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tripBookingId;

	/*
	 * one to one relation with customer
	 */
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customerId", nullable = false)
	@JsonIgnore
	private Customer customer;

	/*
	 * this is driver object having many to one relation
	 */
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "driverId", updatable = false, nullable = false)
	@JsonIgnore
	private Driver driver;

	/*
	 * this is location where customer is picked
	 */
	@NotBlank(message = "From location is required")
	private String fromLocation;

	/*
	 * this is location where customer is droped
	 */
	@NotBlank(message = "To location is required")
	private String toLocation;

	/*
	 * this is time and date when customer is picked
	 */
	private LocalDateTime fromDateTime;

	/*
	 * this is time and date when customer is dropped
	 */
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

	public TripBooking() {
		super();
	}

	public int getTripBookingId() {
		return tripBookingId;
	}

	public void setTripBookingId(int tripBookingId) {
		this.tripBookingId = tripBookingId;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	public LocalDateTime getFromDateTime() {
		return fromDateTime;
	}

	public void setFromDateTime(LocalDateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}

	public LocalDateTime getToDateTime() {
		return toDateTime;
	}

	public void setToDateTime(LocalDateTime toDateTime) {
		this.toDateTime = toDateTime;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public float getDistanceInKm() {
		return distanceInKm;
	}

	public void setDistanceInKm(float distanceInKm) {
		this.distanceInKm = distanceInKm;
	}

	public float getBill() {
		return bill;
	}

	public void setBill(float bill) {
		this.bill = bill;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	

}

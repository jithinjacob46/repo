/**
 * 
 */
package com.problem.parking;

/**
 * @author jacob
 *
 */
public class Vehicle {

	private String registrationNumber;

	public Vehicle(String registrationNumber) {

		super();
		this.registrationNumber = registrationNumber;
	}

	/**
	 * @return the registrationNumber
	 */
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	/**
	 * @param registrationNumber
	 *            the registrationNumber to set
	 */
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

}

/**
 * 
 */
package com.problem.parking;

/**
 * @author jacob
 *
 */
public class Car extends Vehicle {

	private String color;

	public Car(String registrationNumber, String color) {

		super(registrationNumber);
		this.color = color;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

}

/**
 * 
 */
package com.problem.parking;

import java.util.List;
import java.util.stream.IntStream;

/**
 * @author jacob
 *
 */
public class CarParkingLot extends ParkingLot<Car> {

	/**
	 * @param capacity
	 */
	public CarParkingLot(int capacity) {
		super(capacity);
	}

	public String findSlots(String color) {

		StringBuilder stringBuilder = new StringBuilder("");
		List<Car> cars = statusVehicle();
		IntStream.range(0, capacity)
				.filter(index -> cars.get(index) != null && color.equals(cars.get(index).getColor()))
				.forEach(index -> stringBuilder.append(index + 1).append(","));
		String slots = stringBuilder.toString();
		System.out.println(slots);
		return slots;
	}

	public String findRegistrationNumbers(String color) {

		StringBuilder stringBuilder = new StringBuilder("");
		List<Car> cars = statusVehicle();
		cars.stream().filter(car -> car != null && color.equals(car.getColor()))
				.forEach(car -> stringBuilder.append(car.getRegistrationNumber()).append(","));
		String registrationNumbers = stringBuilder.toString();
		System.out.println(registrationNumbers);
		return registrationNumbers;
	}

}

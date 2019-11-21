/**
 * 
 */
package com.problem.parking;

import java.util.List;
import java.util.stream.Collectors;
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

		List<Car> cars = slots;
		List<String> slots = IntStream.range(0, capacity)
				.filter(index -> cars.get(index) != null && color.equals(cars.get(index).getColor()))
				.mapToObj(index -> String.valueOf(index + 1)).collect(Collectors.toList());
		System.out.println(String.join(", ", slots));
		return slots.toString();
	}

	public String findRegistrationNumbers(String color) {

		List<Car> cars = slots;
		List<String> registrationNumbers = cars.stream().filter(car -> car != null && color.equals(car.getColor()))
				.map(Car::getRegistrationNumber).collect(Collectors.toList());
		System.out.println(String.join(", ", registrationNumbers));
		return registrationNumbers.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.problem.parking.ParkingLot#status()
	 */
	@Override
	public String status() {

		List<String> vehicles = statusVehicle();
		StringBuilder stringBuilder = new StringBuilder("Slot No. Registration No Color \n");
		vehicles.stream().forEach(vehicle -> stringBuilder.append(vehicle));
		String status = stringBuilder.toString();
		System.out.println(status);
		return status;
	}

}

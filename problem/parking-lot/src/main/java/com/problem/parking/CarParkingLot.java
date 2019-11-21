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

		List<Car> cars = statusVehicle();
		List<String> slots = IntStream.range(0, capacity)
				.filter(index -> cars.get(index) != null && color.equals(cars.get(index).getColor()))
				.mapToObj(index -> String.valueOf(index + 1)).collect(Collectors.toList());
		System.out.println(slots.toString());
		return slots.toString();
	}

	public String findRegistrationNumbers(String color) {

		List<Car> cars = statusVehicle();
		List<String> registrationNumbers = cars.stream().filter(car -> car != null && color.equals(car.getColor()))
				.map(Car::getRegistrationNumber).collect(Collectors.toList());
		System.out.println(registrationNumbers.toString());
		return registrationNumbers.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.problem.parking.ParkingLot#status()
	 */
	@Override
	public String status() {

		List<Car> vehicles = slots;
		StringBuilder stringBuilder = new StringBuilder("Slot No. Registration No Color \n");
		IntStream.range(0, capacity).forEach(index -> {
			Car car = vehicles.get(index);
			if (car != null) {
				stringBuilder.append((index + 1) + "\t" + car.getRegistrationNumber() + "\t" + car.getColor() + "\n");
			} else {
				stringBuilder.append("\n");
			}
		});
		String status = stringBuilder.toString();
		System.out.println(status);
		return status;
	}

}

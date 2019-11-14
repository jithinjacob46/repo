/**
 * 
 */
package com.problem.parking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author jacob
 *
 */
public class ParkingLot<T extends Vehicle> {

	private int capacity;
	private List<T> slots;

	public ParkingLot(int capacity) {

		super();
		this.capacity = capacity;
		slots = new ArrayList<>(capacity);
		for (int i = 0; i < capacity; i++) {
			slots.add(null);
		}
	}

	public String park(T vehicle) {

		String park = null;
		int slot = this.parkVehicle(vehicle);
		if (slot > 0) {
			park = "Allocated slot number: " + slot + " to vehicle " + vehicle.getRegistrationNumber();
		} else {
			park = "Sorry, parking lot is full";
		}
		System.out.println(park);
		return park;
	}

	protected int parkVehicle(T vehicle) {

		int slot = IntStream.range(0, capacity).filter(index -> slots.get(index) == null).findFirst().orElse(-1);
		if (slot > -1) {
			slots.set(slot, vehicle);
		}
		return slot + 1;
	}

	public String leave(int slot) {

		String leave = null;
		T vehicle = this.leaveVehicle(slot - 1);
		if (vehicle != null) {
			leave = "Vehicle " + vehicle.getRegistrationNumber() + " left slot number " + slot;
		}
		System.out.println(leave);
		return leave;
	}

	protected T leaveVehicle(int slot) {

		T vehicle = slots.get(slot);
		if (vehicle != null) {
			slots.set(slot, null);
			return vehicle;
		}
		return null;
	}

	public String findSlot(T vehicle) {

		int slot = findSlotVehicle(vehicle);
		String parkingSlot;
		if (slot > 0) {
			parkingSlot = "Slot number: " + slot;
		} else {
			parkingSlot = "Not found";
		}
		System.out.println(parkingSlot);
		return parkingSlot;
	}

	protected int findSlotVehicle(T vehicle) {

		int slot = slots.indexOf(vehicle);
		return slot + 1;
	}

	public String status() {

		List<T> vehicles = statusVehicle();
		StringBuilder stringBuilder = new StringBuilder("Registration No \n");
		vehicles.stream().forEach(vehicle -> {
			if (vehicle != null) {
				stringBuilder.append(vehicle.getRegistrationNumber() + "\n");
			} else {
				stringBuilder.append("\n");
			}
		});
		String status = stringBuilder.toString();
		System.out.println(status);
		return status;
	}

	protected List<T> statusVehicle() {

		return slots;
	}

}

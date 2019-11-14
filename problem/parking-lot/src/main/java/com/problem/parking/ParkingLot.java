/**
 * 
 */
package com.problem.parking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author jacob
 *
 */
public class ParkingLot {

	private int capacity;
	private List<Vehicle> slots;

	public ParkingLot(int capacity) {

		super();
		this.capacity = capacity;
		slots = new ArrayList<>(capacity);
		for (int i = 0; i < capacity; i++) {
			slots.add(null);
		}
	}

	protected int park(Vehicle vehicle) {

		int slot = IntStream.range(0, capacity).filter(index -> slots.get(index) == null).findFirst().orElse(-1);
		if (slot > -1) {
			slots.set(slot, vehicle);
		}
		return slot + 1;
	}

	public Vehicle leave(int slot) {

		Vehicle vehicle = slots.get(slot);
		if (vehicle != null) {
			slots.set(slot, null);
			return vehicle;
		}
		return null;
	}

	public int findSlot(Vehicle vehicle) {

		String registrationNumber = vehicle.getRegistrationNumber();
		int slot = IntStream.range(0, capacity).filter(index -> slots.get(index) != null
				&& slots.get(index).getRegistrationNumber().equals(registrationNumber)).findFirst().orElse(-1);
		return slot + 1;
	}

	public List<Vehicle> status() {

		List<Vehicle> vehicles = slots.stream().filter(vehicle -> vehicle != null).collect(Collectors.toList());
		return vehicles;
	}

}

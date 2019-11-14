/**
 * 
 */
package com.problem.parking;

import org.junit.Test;

/**
 * @author jacob
 *
 */
public class CarParkingTest {

	@Test
	public void test() {

		ParkingLot<Vehicle> parkingLot = new ParkingLot<>(6);
		parkingLot.park(new Vehicle("KA-01-HH-1234"));
		parkingLot.park(new Vehicle("KA-01-HH-9999"));
		parkingLot.park(new Vehicle("KA-01-BB-0001"));
		parkingLot.park(new Vehicle("KA-01-HH-7777"));
		parkingLot.park(new Vehicle("KA-01-HH-2701"));
		parkingLot.park(new Vehicle("KA-01-HH-3141"));

		parkingLot.leave(4);
		parkingLot.status();

		parkingLot.park(new Vehicle("KA-01-P-333"));
		parkingLot.park(new Vehicle("DL-12-AA-9999"));

		parkingLot.findSlot(new Vehicle("KA-01-HH-3141"));
		parkingLot.findSlot(new Vehicle("MH-04-AY-1111"));

	}

}

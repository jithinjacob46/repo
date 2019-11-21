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

		CarParkingLot parkingLot = new CarParkingLot(6);
		parkingLot.park(new Car("KA-01-HH-1234", "White"));
		parkingLot.park(new Car("KA-01-HH-9999", "White"));
		parkingLot.park(new Car("KA-01-BB-0001", "Black"));
		parkingLot.park(new Car("KA-01-HH-7777", "Red"));
		parkingLot.park(new Car("KA-01-HH-2701", "Blue"));
		parkingLot.park(new Car("KA-01-HH-3141", "Black"));

		parkingLot.leave(4);
		parkingLot.status();

		parkingLot.park(new Car("KA-01-P-333", "White"));
		parkingLot.park(new Car("DL-12-AA-9999", "White"));

		parkingLot.findSlots("White");
		parkingLot.findRegistrationNumbers("White");

		parkingLot.findSlot(new Car("KA-01-HH-3141", null));
		parkingLot.findSlot(new Car("MH-04-AY-1111", null));

	}

}

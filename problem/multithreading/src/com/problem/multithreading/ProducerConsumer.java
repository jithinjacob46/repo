/**
 * 
 */
package com.problem.multithreading;

import java.util.LinkedList;
import java.util.List;

/**
 * @author jacob
 *
 */
public class ProducerConsumer {

	private List<Integer> list = new LinkedList<>();
	private int capacity;

	/**
	 * @param capacity
	 */
	public ProducerConsumer(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * @throws InterruptedException
	 * 
	 */
	public void produce() throws InterruptedException {

		int value = 0;
		while (true) {

			synchronized (this) {

				while (list.size() == capacity) {
					wait();
				}

				System.out.println("Produced value " + value);
				list.add(value++);

				notify();

				Thread.sleep(1000);
			}
		}
	}

	/**
	 * @throws InterruptedException
	 * 
	 */
	public void consume() throws InterruptedException {

		while (true) {

			synchronized (this) {

				while (list.size() == 0) {
					wait();
				}

				int value = list.remove(0);
				System.out.println("Consumed value " + value);

				notify();

				Thread.sleep(1000);
			}

		}
	}

}

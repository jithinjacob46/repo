/**
 * 
 */
package com.problem.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class SequenceThread implements Runnable {

	private static final Object mutex = new Object();
	private static AtomicInteger count = new AtomicInteger(1);
	private int remainder;
	private int dividend;

	/**
	 * @param remainder
	 * @param dividend
	 */
	public SequenceThread(int remainder, int dividend) {
		super();
		this.remainder = remainder;
		this.dividend = dividend;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {

		try {
			while (true) {
				Thread.sleep(1000);
				synchronized (mutex) {

					if (count.get() % dividend != remainder) {
						mutex.wait();
					} else {
						System.out.println("Printed " + count.getAndIncrement() + " in thread "
								+ Thread.currentThread().getName());
						mutex.notifyAll();
					}
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
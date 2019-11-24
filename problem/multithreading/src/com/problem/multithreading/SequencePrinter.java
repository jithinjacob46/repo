/**
 * 
 */
package com.problem.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jacob
 *
 */
public class SequencePrinter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final int NO_OF_THREADS = 5;

		List<Thread> threads = new ArrayList<>();
		for (int i = 0; i < NO_OF_THREADS; i++) {
			SequenceThread sequenceThread = new SequenceThread(i, NO_OF_THREADS);
			threads.add(new Thread(sequenceThread, "Thread" + (i == 0 ? NO_OF_THREADS : i)));
		}

		for (int i = 0; i < NO_OF_THREADS; i++) {
			threads.get(i).start();
		}
	}

	public static class SequenceThread implements Runnable {

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
}

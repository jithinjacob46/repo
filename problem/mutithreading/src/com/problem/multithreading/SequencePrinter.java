/**
 * 
 */
package com.problem.multithreading;

import java.util.ArrayList;
import java.util.List;

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

		final int NO_OF_THREADS = 4;

		List<Thread> threads = new ArrayList<>();
		for (int i = 0; i < NO_OF_THREADS; i++) {
			SequenceThread sequenceThread = new SequenceThread(i, NO_OF_THREADS);
			threads.add(new Thread(sequenceThread));
		}

		for (int i = 0; i < NO_OF_THREADS; i++) {
			threads.get(i).start();
		}
	}

	public static class SequenceThread implements Runnable {

		private static final Object mutex = new Object();
		private static volatile int count = 1;
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
			// TODO Auto-generated method stub

			try {
				while (true) {
					Thread.sleep(1000);
					synchronized (mutex) {

						if (count % dividend != remainder) {
							mutex.wait();
						} else {
							System.out.println("Printed " + count + " in thread " + " in thread" + (remainder + 1));
							count++;
							mutex.notifyAll();
						}
					}
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}

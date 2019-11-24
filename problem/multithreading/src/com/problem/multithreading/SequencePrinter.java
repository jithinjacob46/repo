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

		final int NO_OF_THREADS = 3;

		List<Thread> threads = new ArrayList<>();
		for (int i = 0; i < NO_OF_THREADS; i++) {
			SequenceThread sequenceThread = new SequenceThread(i, NO_OF_THREADS);
			threads.add(new Thread(sequenceThread, "Thread" + (i == 0 ? NO_OF_THREADS : i)));
		}

		for (int i = 0; i < NO_OF_THREADS; i++) {
			threads.get(i).start();
		}
	}

}

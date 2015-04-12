package util;

import util.Counter;

public class Counter {

	private static int countTime, timeElapsed;
	private static long startTime, currentTime;
	private static boolean wantToReset = false;



	public Counter(int countTime) {
		Counter.countTime = countTime;
		startTime = System.currentTimeMillis();
		currentTime = 0;

	}

	public void Update() {
		currentTime = System.currentTimeMillis();
		while (isCountingDown()) {
			currentTime = System.currentTimeMillis();
			timeElapsed = (int) ((currentTime - startTime) / 1000);
			getTimeElapsed();

		}
		System.out.println("Counting is Done");

		if (wantToReset) {
			resetCounter();

		}

	}

	private boolean isCountingDown() {
		if ((currentTime - startTime) / 1000 >= countTime) {
			return false;

		}

		return true;
	}

	private void resetCounter() {
		startTime = System.currentTimeMillis();

	}
	private int getTimeElapsed(){
		return timeElapsed;
	}
}

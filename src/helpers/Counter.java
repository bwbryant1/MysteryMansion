package helpers;

public class Counter {

	private static int countTime, timeElapsed;
	private static long startTime, currentTime;
	private static boolean wantToReset = true, isRunning;
	private boolean isDone = false;

	/*
	 * public static void main(String[] args) { Counter counter = new
	 * Counter(8); isRunning = true; while (isRunning) { counter.Update(); }
	 * 
	 * }
	 */

	public Counter(int countTime) {
		this.countTime = countTime;
		startTime = System.currentTimeMillis();
		currentTime = 0;
		

	}

	public void Update() {

		if (isCountingDown()) {
			currentTime = System.currentTimeMillis();
			System.out.println((currentTime - startTime) / 1000 + " "
					+ startTime + isCountingDown());

		}
		if (isDone) {
			System.out.println("Counting is Done");
			isRunning = false;

			if (isDone) {
				// isRunning = true;
				resetCounter();
				isDone = false;

			}
		}

	}

	public boolean isCountingDown() {
		if ((currentTime - startTime) / 1000 >= countTime && !isRunning) {
			isDone = true;
			return true;

		}

		return false;
	}

	private void resetCounter() {
		this.startTime = System.currentTimeMillis();

	}

	public static int getCountTime() {
		return countTime;
	}

	public static void setCountTime(int countTime) {
		Counter.countTime = countTime;
	}

	public static int getTimeElapsed() {
		return timeElapsed;
	}

	public static void setTimeElapsed(int timeElapsed) {
		Counter.timeElapsed = timeElapsed;
	}

	public static long getStartTime() {
		return startTime;
	}

	public static void setStartTime(long startTime) {
		Counter.startTime = startTime;
	}

	public static long getCurrentTime() {
		return currentTime;
	}

	public static void setCurrentTime(long currentTime) {
		Counter.currentTime = currentTime;
	}

	public static void setWantToReset(boolean wantToReset) {
		Counter.wantToReset = wantToReset;
	}

	public static boolean isRunning() {
		return isRunning;
	}

	public static void setRunning(boolean isRunning) {
		Counter.isRunning = isRunning;
	}
}

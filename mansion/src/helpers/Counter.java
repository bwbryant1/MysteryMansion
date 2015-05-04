package helpers;

public class Counter {
	public enum countState {
		COUNTER, RESET;
	}

	private static int countTime, timeElapsed, resetTime;

	private static long startTime, currentTime;
	private static boolean wantToReset = true, isRunning;
	public static boolean isRunning() {
		return isRunning;
	}
	public static void main(String[] args) {
		Counter counter = new Counter(2, 4);

		isRunning = true;

		while (true) {
			counter.Update();
		}

	}
	public static void setCountTime(int countTime) {
		Counter.countTime = countTime;
	}

	public static void setResetTime(int resetTime) {
		Counter.resetTime = resetTime;
	}

	public static void setRunning(boolean isRunning) {
		Counter.isRunning = isRunning;
	}

	countState counterState = countState.COUNTER;

	private boolean isDone = false;

	private int currentCount = 0;

	public Counter(int countTime, int ResetTime) {

		if (countTime < 1) {
			countTime = 1;
		}
		if (ResetTime < 1) {
			countTime = 1;
		}

		Counter.countTime = countTime;
		Counter.resetTime = ResetTime;
		startTime = System.currentTimeMillis();
		currentTime = 0;

	}

	private void resetCountTime() {
		currentCount = 0;
		startTime = System.currentTimeMillis();

	}

	public void Update() {
		currentTime = System.currentTimeMillis();
		timeElapsed = (int) ((currentTime - startTime) / 1000);

		
			//System.out.println(timeElapsed);
			if(timeElapsed > countTime + resetTime){
				resetCountTime();
			}
		
		switch (counterState) {
		case COUNTER:
			
			
			if (timeElapsed == countTime) {
				counterState = countState.RESET;
				//System.out.println("RESET");
				resetCountTime();
			}else{
				isRunning = true;

			}
			break;
		case RESET:
			
			if (timeElapsed == resetTime) {
				counterState = countState.COUNTER;
				//System.out.println("COUNTER");
				resetCountTime();
			}else{
				isRunning = false;
				
			}
			break;
		}

	}

	

}

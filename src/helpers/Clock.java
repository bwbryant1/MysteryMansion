package helpers;

import org.lwjgl.Sys;

public class Clock {

	public static float d = 0, multiplier = 2;
	public static long lastFrame, totalTime;
	private static boolean paused = false;

	public static void ChangeMultiplier(int change) {
		if (multiplier + change < -1 && multiplier + change > 7) {

		} else
			multiplier += change;

	}

	public static float Delta() {

		if (paused)
			return 0;
		else
			return d * multiplier;
	}

	public static float getDelta() {
		long currentTime = getTime();
		int delta = (int) (currentTime - lastFrame);
		lastFrame = getTime();
		if (delta * 0.001F > 0.017)
			return 0.017f;
		return delta * 0.001F;

	}

	public static long getTime() {
		return Sys.getTime() * 1000 / Sys.getTimerResolution();

	}

	public static float Multiplier() {
		return multiplier;
	}

	public static void Pause() {
		if (paused)
			paused = false;
		else
			paused = true;
	}

	public static float TotalTime() {

		return totalTime;
	}

	public static void Update() {
		d = getDelta();
		totalTime = totalTime += d;
	}
}

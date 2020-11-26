package exc_1.timer;

public final class Timer {
	private static long startNs;
	private static long lastDeltaNs;
	
	public enum OutputType {
		Minute,
		Second,
		Millisecond,
		Nanosecond
	}
	
	public Timer() {
		startNs = 0;
		lastDeltaNs = 0;
	}
	
	public static void startTimer() {
		startNs = System.nanoTime();
	}
	
	public static long stopTimer() {
		return stopTimer(OutputType.Nanosecond);
	}
	
	public static long stopTimer(OutputType type) {
		lastDeltaNs = System.nanoTime() - startNs;
		long deltaTime = lastDeltaNs;
		
		switch (type) {
			case Minute: deltaTime /= 60;
			case Second: deltaTime /= 1000;
			case Millisecond: deltaTime /= 1000000;
			case Nanosecond:
			default:
		}
		
		return deltaTime;
	}
	
	public static long getLastDeltaNs() {
		return lastDeltaNs;
	}
}

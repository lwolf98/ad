package exc_7;

import java.util.Random;

public class TestNull {
	public static void main(String[] args) {
		testNull();
		
		String str = "abc";
		testNull2(str);
		System.out.println(str);
	}
	
	/*
	 * Das lokale str hier speichert nur eine Kopie der Referenz
	 * des str aus main().
	 * Folglich hat das null-Setzten hier auch keine Auswirkung
	 * auf das str aus main().
	 */
	private static void testNull2(String str) {
		str = null;
	}
	
	private static void testNull() {
		String test = "Hella!";
		String curr = test;
		
		System.out.println("Before set null:");
		System.out.println("test: " + test);
		System.out.println("curr: " + curr);
		
		curr = null;
		
		System.out.println("After set null:");
		System.out.println("test: " + test);
		System.out.println("curr: " + curr + "\n");
		
		
		Random rndTest = new Random();
		Random rndCurr = rndTest;
		
		System.out.println("Before set null:");
		System.out.println("rndTest: " + rndTest);
		System.out.println("rndCurr: " + rndCurr);
		
		rndCurr = null;
		
		System.out.println("After set null:");
		System.out.println("rndTest: " + rndTest);
		System.out.println("rndCurr: " + rndCurr);
	}
}

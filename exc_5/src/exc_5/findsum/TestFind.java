package exc_5.findsum;

import java.util.Arrays;
import java.util.Random;

public class TestFind {
	public static void main(String[] args) {
		//int[] a = {1, 2, 3, 9, 3, 4, 9, 0, 3, 2};
		int[] a = {-1, -5, -10, -12};
		SumFinderBasic basicFinder = new SumFinderBasic();
		SumFinderHeap heapFinder = new SumFinderHeap();
		SumFinderLudwig ludwigFinder = new SumFinderLudwig();
		
		for(int j = 0; j < 1000; j++) {
			a = createRndArr(100);
			for(int i = -15; i <= 15; i++) {
				int[] tmp = Arrays.copyOf(a, a.length);
				boolean foundBasic = basicFinder.findSum(tmp, i);
				tmp = Arrays.copyOf(a, a.length);
				boolean foundHeap = heapFinder.findSum(tmp, i);
				tmp = Arrays.copyOf(a, a.length);
				boolean foundLudwig = ludwigFinder.findSum(tmp, i);
				
				if(!(foundBasic == foundHeap && foundHeap == foundLudwig)) {
					System.out.println("Error!");
					tmp = Arrays.copyOf(a, a.length);
					heapFinder.findSum(tmp, i);
					System.out.println(foundBasic + ", " + foundHeap + ", " + foundLudwig);
				}
			}
		}
		
		/*
		 * Ergebnis:
		 * - SumFinderBasic funktioniert in O(n²).
		 * - SumFinderHeap funktioniert nicht.
		 * - SumFinderLudwig funktioniert in Theta(n log(n))
		 * 		> Laufzeit ergibt sich durch das Vorsortieren.
		 * 		> Das Finden der Summe bei einem sortierten Array geschieht mit linearer Lauzeit.
		 */
	}
	
	private static int[] createRndArr(int size) {
		int[] arr = new int[size];
		Random r = new Random();
		for(int i = 0; i < arr.length; i++)
			arr[i] = r.nextInt(100) - 50;
		
		return arr;
	}
}

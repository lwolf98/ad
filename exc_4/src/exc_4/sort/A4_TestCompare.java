package exc_4.sort;

import java.util.Random;

import exc_4.sort.algorithms.BubbleSort;
import exc_4.sort.algorithms.QuickSort;
import exc_4.sort.algorithms.QuickSortBase;
import exc_4.sort.algorithms.QuickSortRandomPv;
import exc_4.sort.algorithms.SortAlgorithm;

public class A4_TestCompare {
	public static void main(String[] args) {

		BubbleSort bubble = new BubbleSort();
		QuickSortBase quick = new QuickSort();
		
		/*
		 * Voraussetzungen für die Berechnung:
		 * Es werden jeweils Arrays mit 50.000 Einträgen (von 0 bis 99) sortiert.
		 * Gezählt wird die Anzahl an abgearbeiteten Arrays nach einer Minute.
		 * Diese Anzahl wird dann mit 50.000 multipliziert, um die Anzahl der einzelnen sortierten Zahlen zu erhalten.
		 */
		
		int[][] rndArrs = createRndArrs(10000, 50000);
		sortPerTime(bubble, 60, rndArrs);
		//Ergebnis: 750.000 Zahlen pro Minute
		
		rndArrs = createRndArrs(10000, 50000);
		sortPerTime(quick, 60, rndArrs);
		//Ergebnis: 142.200.000 Zahlen pro Minute
		
		quick = new QuickSortRandomPv();
		rndArrs = createRndArrs(10000, 50000);
		sortPerTime(quick, 60, rndArrs);
		//Ergebnis: 110.250.000 Zahlen pro Minute
	}
	
	private static void sortPerTime(SortAlgorithm sort, int seconds, int[][] toBeSorted) {
		long start = System.currentTimeMillis();
		long end = start + seconds * 1000;
		long cnt = 0;
		
		int innerLen = toBeSorted[0].length;
		int i = 0;
		while(System.currentTimeMillis() < end) {
			if(i >= toBeSorted.length)
				break;
			
			sort.sort(toBeSorted[i]);
			cnt++;
			i++;
		}
		
		System.out.println("Sorted after (seconds): " + (System.currentTimeMillis() - start));
		System.out.println("Count: " + cnt * innerLen);
	}
	
	private static int[][] createRndArrs(int sizeOuter, int sizeInner) {
		int[][] rndArrs = new int[sizeOuter][];
		for(int i = 0; i < sizeOuter; i++)
			rndArrs[i] = createRndArr(sizeInner);
		
		return rndArrs;
	}
	
	private static int[] createRndArr(int size) {
		int[] arr = new int[size];
		Random r = new Random();
		for(int i = 0; i < arr.length; i++)
			arr[i] = r.nextInt(100);
		
		return arr;
	}
}

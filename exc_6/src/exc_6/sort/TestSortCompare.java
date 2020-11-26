package exc_6.sort;

import java.util.Random;

import exc_6.sort.algorithms.CountSort;
import exc_6.sort.algorithms.CountSort2k3n;
import exc_6.sort.algorithms.CountSort5k3n;
import exc_6.sort.algorithms.CountSortIdea;
import exc_6.sort.algorithms.HeapSort;
import exc_6.sort.algorithms.MapSort;
import exc_6.sort.algorithms.SortAlgorithm;
import exc_6.timer.Timer;
import exc_6.timer.Timer.OutputType;

public class TestSortCompare {
	private static Random rnd = new Random();
	private static int lBound = 1000;
	private static int uBound = 10000;
	
	public static void main(String[] args) {
		int loops = 10000;
		
		int size = 10;
		System.out.println("Size: " + size);
		tst(new HeapSort(), size, loops);
		tst(new CountSort(uBound), size, loops);
		tst(new CountSort2k3n(uBound), size, loops);
		tst(new CountSort5k3n(uBound), size, loops);
		tst(new CountSortIdea(uBound), size, loops);
		tst(new MapSort(1.5), size, loops);
		System.out.println();
		//Ergebnis: HeapSort, MapSort ähnlich schnell; CountSort deutlich langsamer

		size = 1000;
		System.out.println("Size: " + size);
		tst(new HeapSort(), size, loops);
		tst(new CountSort(uBound), size, loops);
		tst(new CountSort2k3n(uBound), size, loops);
		tst(new CountSort5k3n(uBound), size, loops);
		tst(new CountSortIdea(uBound), size, loops);
		tst(new MapSort(1.5), size, loops);
		System.out.println();
		//Ergebnis: MapSort, CountSort ähnlich schnell; HeapSort langsamer

		size = 10000;
		System.out.println("Size: " + size);
		tst(new HeapSort(), size, loops);
		tst(new CountSort(uBound), size, loops);
		tst(new CountSort2k3n(uBound), size, loops);
		tst(new CountSort5k3n(uBound), size, loops);
		tst(new CountSortIdea(uBound), size, loops);
		tst(new MapSort(1.5), size, loops);
		System.out.println();
		//Ergebnis: CountSort am schnellsten; MapSort langsamer; HeapSort deutlich langsamer
		
		/*loops = 1000;
		size = 100000;
		System.out.println("Size: " + size + ", Loops: " + loops);
		tst(new HeapSort(), size, loops);
		tst(new CountSort(uBound), size, loops);
		tst(new CountSort2k3n(uBound), size, loops);
		tst(new CountSort5k3n(uBound), size, loops);
		tst(new CountSortIdea(uBound), size, loops);
		tst(new MapSort(1.5), size, loops);
		tst(new MapSort(1.25), size, loops);*/
		
	}
	
	private static void tst(SortAlgorithm s, int size, int loops) {
		int[][] arrays = new int[loops][];
		for(int j = 0; j < loops; j++) {
			arrays[j] = new int[size];
			for(int i = 0; i < arrays[0].length; i++)
				arrays[j][i] = rnd.nextInt(uBound - lBound) + lBound;
		}
		
		Timer.startTimer();
		for(int j = 0; j < loops; j++)
			s.sort(arrays[j]);

		System.out.println("Time (" + s.getClass().getSimpleName() + "): " + Timer.stopTimer(OutputType.Millisecond) + "ms");
	}
}

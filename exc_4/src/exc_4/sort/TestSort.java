package exc_4.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import exc_4.sort.algorithms.BubbleSort;
import exc_4.sort.algorithms.HeapSort;
import exc_4.sort.algorithms.InsertionSort;
import exc_4.sort.algorithms.OtherInsertionSort;
import exc_4.sort.algorithms.QuickSort;
import exc_4.sort.algorithms.QuickSortRandomPv;
import exc_4.sort.algorithms.SelectionSort;
import exc_4.sort.algorithms.SortAlgorithm;

public class TestSort {
	private static int[] arr;
	private static Random rnd;
	
	public static void main(String[] args) {
		/* for testing */
		
		arr = new int[10];
		
		rnd = new Random();
		
		for(int i =  0; i < arr.length; i++)
			arr[i] = rnd.nextInt(100) + 1;
		
		//arr = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		
		List<SortAlgorithm> sorts = new ArrayList<SortAlgorithm>();
		sorts.add(new BubbleSort());
		sorts.add(new InsertionSort());
		sorts.add(new HeapSort());
		sorts.add(new QuickSort());
		sorts.add(new QuickSortRandomPv());
		sorts.add(new SelectionSort());
		sorts.add(new OtherInsertionSort());
		
		for(SortAlgorithm s : sorts)
			executeSortAndPrint(s);
		
		arr = new int[] {23, 40, 4, 76, 98, 74, 32, 59, 46, 72};
		executeSortAndPrint(new HeapSort());
		executeSortAndPrint(new QuickSort());
	}
	
	private static void executeSortAndPrint(SortAlgorithm s) {
		int[] arrSort = Arrays.copyOf(arr, arr.length);
		System.out.println(joinInts(arrSort, " "));
		System.out.println("to (" + s.getClass().getSimpleName() + "):");
		s.sort(arrSort);
		System.out.println(joinInts(arrSort, " ") + "\n");
	}
	
	private static String joinInts(int arr[], String delimiter) {
		String result = "";
		for(int i = 0; i < arr.length; i++)
			result += arr[i] + delimiter;
		
		return result.substring(0, result.length() - delimiter.length());
	}
}

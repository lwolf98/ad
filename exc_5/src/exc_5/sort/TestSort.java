package exc_5.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import exc_5.sort.algorithms.InsertionSort;
import exc_5.sort.algorithms.InsertionSortRecursive;
import exc_5.sort.algorithms.MergeSort;
import exc_5.sort.algorithms.MergeSortIterative;
import exc_5.sort.algorithms.SortAlgorithm;

public class TestSort {
	private static int[] arr;
	private static Random rnd;
	
	public static void main(String[] args) {
		/* for testing */
		
		arr = new int[7];
		
		rnd = new Random();
		
		for(int i =  0; i < arr.length; i++)
			arr[i] = rnd.nextInt(100) + 1;
		
		//arr = new int[] {-5, 13, -32, 7, -3, 17, 23, 12, -35, 19};
		//arr = new int[] {-5, 13, -32, 7, -3, 17, 23, 12, -35, 19, -50};
		
		List<SortAlgorithm> sorts = new ArrayList<SortAlgorithm>();
		sorts.add(new InsertionSort());
		sorts.add(new InsertionSortRecursive());
		sorts.add(new MergeSort());
		sorts.add(new MergeSortIterative());
		
		for(SortAlgorithm s : sorts)
			executeSortAndPrint(s);
		
		boolean resultsEquivalent = true;
		for(int i = 0; i < 100000; i++) {
			for(int j =  0; j < arr.length; j++)
				arr[j] = rnd.nextInt(100) + 1;
			
			String[] res = new String[sorts.size()];
			
			for(int j = 0; j < sorts.size(); j++)
				res[j] = executeSortAndPrint(sorts.get(j));
			
			if(!(res[0].equals(res[1]) && res[1].equals(res[2]) && res[2].equals(res[3]))) {
				System.err.println("Error!");
				resultsEquivalent = false;
				break;
			}
		}
		
		if(resultsEquivalent)
			System.out.println("Sort results are equivalent");
	}
	
	private static String executeSortAndPrint(SortAlgorithm s) {
		int[] arrSort = Arrays.copyOf(arr, arr.length);
		System.out.println(joinInts(arrSort, " "));
		System.out.println("to (" + s.getClass().getSimpleName() + "):");
		s.sort(arrSort);
		String result = joinInts(arrSort, " ") + "\n";
		System.out.println(result);
		return result;
	}
	
	private static String joinInts(int arr[], String delimiter) {
		String result = "";
		for(int i = 0; i < arr.length; i++)
			result += arr[i] + delimiter;
		
		return result.substring(0, result.length() - delimiter.length());
	}
}

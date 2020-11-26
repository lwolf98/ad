package exc_4.sort.algorithms;

public class BubbleSortMax extends SortAlgorithm {

	/**
	 * Laufzeit: O(n²) (in jedem Fall)
	 * Die Laufzeit der beiden Varianten ist identisch.
	 * 
	 */
	@Override
	public void sort(int[] a) {
		int n = a.length;
		
		for(int i = 0; i < n; i++)
			for(int j = 1; j < n - i; j++)
				if(a[j - 1] > a[j])
					swap(a, j, j - 1);
		
	}
}

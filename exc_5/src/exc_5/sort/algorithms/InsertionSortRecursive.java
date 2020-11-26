package exc_5.sort.algorithms;

/**
 * - for-Schleife (ohne Operationen): O(n)
 * - Rekursion (insert()):
 * 		> Fall 1 - Vorsortiert: O(1), da die Rekursion nicht aufgerufen wird
 * 		> Fall 2 - Durcheinander: O(n), da das Array im Worst Case über die gesamte Länge durchlaufen werden muss
 * 
 *  - Best Case: O(n)
 *  - Worst Case: O(n²)
 * 
 */
public class InsertionSortRecursive extends SortAlgorithm {

	@Override
	public void sort(int[] a) {
		int n = a.length;
		
		for(int i = 1; i < n; i++)
			insert(a, a[i], i - 1);

	}
	
	private void insert(int[] a, int key, int j) {
		if(j >= 0 && a[j] > key) {
			a[j + 1] = a[j];
			insert(a, key, j - 1);
			return;
		}
		
		a[j + 1] = key;
	}
}

package exc_5.sort.algorithms;

public abstract class QuickSortBase extends SortAlgorithm {
	protected int preparePartition(int[] a, int f, int l) {
		int pivot = a[f];
		int p = f - 1;
		
		for(int i = f; i <= l; i++) {
			if(a[i] <= pivot) {
				p++;
				swap(a, i, p);
			}
		}
		
		swap(a, f, p);
		return p;
	}
}

package exc_6.sort.algorithms.generic;

public abstract class QuickSortBase extends SortAlgorithm {
	protected <T extends Comparable<T>> int preparePartition(T[] a, int f, int l) {
		T pivot = a[f];
		int p = f - 1;
		
		for(int i = f; i <= l; i++) {
			if(a[i].compareTo(pivot) <= 0) {
				p++;
				swap(a, i, p);
			}
		}
		
		swap(a, f, p);
		return p;
	}
}

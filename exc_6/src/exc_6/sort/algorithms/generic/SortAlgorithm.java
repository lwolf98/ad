package exc_6.sort.algorithms.generic;

public abstract class SortAlgorithm {
	public abstract <T extends Comparable<T>> void sort(T[] a);
	
	protected static <T> void swap(T[] a, int i, int j) {
		T tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}

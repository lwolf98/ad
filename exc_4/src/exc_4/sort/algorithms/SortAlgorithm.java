package exc_4.sort.algorithms;

public abstract class SortAlgorithm {
	public abstract void sort(int[] a);
	
	protected static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}

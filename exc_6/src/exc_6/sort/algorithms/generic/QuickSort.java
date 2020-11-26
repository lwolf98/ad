package exc_6.sort.algorithms.generic;

public class QuickSort extends QuickSortBase {

	@Override
	public <T extends Comparable<T>> void sort(T[] a) {
		quickSort(a, 0, a.length - 1);
	}
	
	private <T extends Comparable<T>> void quickSort(T[] a, int f, int l) {
		if(f < l) {
			int part = preparePartition(a, f, l);
			quickSort(a, f, part - 1);
			quickSort(a, part + 1, l);
		}
	}
}

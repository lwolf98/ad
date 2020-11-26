package exc_4.sort.algorithms;

public class QuickSort extends QuickSortBase {

	@Override
	public void sort(int[] a) {
		quickSort(a, 0, a.length - 1);
	}
	
	private void quickSort(int[] a, int f, int l) {
		if(f < l) {
			int part = preparePartition(a, f, l);
			quickSort(a, f, part - 1);
			quickSort(a, part + 1, l);
		}
	}
}

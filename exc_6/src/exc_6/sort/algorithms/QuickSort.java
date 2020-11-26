package exc_6.sort.algorithms;

public class QuickSort extends QuickSortBase {

	@Override
	public int[] sort(int[] a) {
		quickSort(a, 0, a.length - 1);
		return a;
	}
	
	private void quickSort(int[] a, int f, int l) {
		if(f < l) {
			int part = preparePartition(a, f, l);
			quickSort(a, f, part - 1);
			quickSort(a, part + 1, l);
		}
	}
}

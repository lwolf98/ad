package exc_4.sort.algorithms;

public class OtherInsertionSort extends SortAlgorithm {
	@Override
	public void sort(int[] a) {
		for(int i = 1; i < a.length; i++) {
			int key = a[i];
			int j;
			for(j = i - 1; j >= 0; j--) {
				if(a[j] > key) a[j+1] = a[j];
				else break;
			}
			a[j+1] = key;
		}
	}
}

package exc_4.sort.algorithms;

public class SelectionSort extends SortAlgorithm {

	@Override
	public void sort(int[] a) {
		int n = a.length;
		
		for(int i = 0; i < n; i++) {
			int min = i;
			
			for(int j = i + 1; j < n; j++)
				if(a[j] < a[min])
					min = j;
			
			swap(a, min, i);
		}
	}
}

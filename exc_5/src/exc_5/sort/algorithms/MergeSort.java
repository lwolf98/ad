package exc_5.sort.algorithms;

public class MergeSort extends SortAlgorithm {
	@Override
	public void sort(int[] a) {
		mergeSort(a, 0, a.length - 1);	
	}
	
	private void mergeSort(int[] a, int f, int l) {
		if(f < l) {
			int m = (f + l + 1) / 2;
			mergeSort(a, f, m - 1);
			mergeSort(a, m, l);
			merge(a, f, l, m);
		}
	}
	
	private void merge(int[] a, int f, int l, int m) {
		int n = l - f + 1;
		int a1f = f, a1l = m - 1;
		int a2f = m, a2l = l;
		int[]aNew = new int[n];
		
		for(int i = 0; i < n; i++) {
			if(a1f <= a1l) {
				if(a2f <= a2l) {
					if(a[a1f] <= a[a2f]) aNew[i] = a[a1f++];
					else aNew[i] = a[a2f++];
				} else aNew[i] = a[a1f++];
			} else aNew[i] = a[a2f++];
		}
		
		for(int i = 0; i < n; i++)
			a[f + i] = aNew[i];
	}
}

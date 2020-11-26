package exc_4.sort.algorithms;

public class SelectionSortMax extends SortAlgorithm {

	@Override
	public void sort(int[] a) {
		int n = a.length;
		
		for(int i = n - 1; i >= 0; i--) {
			int max = i;
			
			for(int j = i; j >= 0; j--)
				if(a[j] > a[max])
					max = j;
			
			swap(a, max, i);
		}
	}
}

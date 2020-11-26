package exc_4.sort.algorithms;

public class BubbleSort extends SortAlgorithm {

	@Override
	public void sort(int[] a) {
		int n = a.length;
		
		for(int i = 0; i < n; i++)
			for(int j = n - 2; j >= i; j--)
				if(a[j + 1] < a[j])
					swap(a, j, j + 1);
		
	}
}

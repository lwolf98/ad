package exc_6.sort.algorithms;

public class CountSort extends SortAlgorithm {
	public int k;
	
	public CountSort(int k) {
		this.k = k;
	}
	
	@Override
	public int[] sort(int[] a) {
		int j = 1;
		int n = a.length;
		int[] bin = new int[k + 1];
		
		//for(int i = 1; i <= k; i++)
		//	bin[i] = 0;
		
		for(int i = 0; i < n; i++)
			bin[a[i]]++;
		
		for(int i = 0; i < n; i++) {
			while(bin[j] == 0)
				j++;
			
			a[i] = j;
			bin[j]--;
		}
		
		return a;
	}
}

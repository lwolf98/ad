package exc_6.sort.algorithms;

public class CountSort2k3n extends SortAlgorithm {
	public int k;
	
	public CountSort2k3n(int k) {
		this.k = k;
	}
	
	@Override
	public int[] sort(int[] a) {
		int n = a.length;
		int[] bin = new int[k + 1];
		int[] out = new int[n];
		
		//for(int i = 1; i <= k; i++)
		//	bin[i] = 0;
		
		for(int i = 0; i < n; i++)
			bin[a[i]]++;
		
		for(int i = 2; i <= k; i++)
			bin[i] += bin[i - 1];
		
		for(int i = n - 1; i >= 0; i--)
			out[bin[a[i]]-- - 1] = a[i];
		
		return out;
	}
}

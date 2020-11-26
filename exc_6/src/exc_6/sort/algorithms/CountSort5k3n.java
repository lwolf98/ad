package exc_6.sort.algorithms;

public class CountSort5k3n extends SortAlgorithm {
	public int k;
	
	public CountSort5k3n(int k) {
		this.k = k;
	}
	
	@Override
	public int[] sort(int[] a) {
		int n = a.length;
		int[] bin = new int[k + 1];
		
		//for(int i = 1; i <= k; i++)
		//	bin[i] = 0;
		
		for(int i = 0; i < n; i++)
			bin[a[i]]++;
		
		for(int i = 2; i <= k; i++)
			bin[i] += bin[i - 1];
		
		int last = 0;
		int next;
		for(int i = 1; i <= k; i++) {
			next = bin[i];
			while(bin[i] > last) {
				a[bin[i]-- - 1] = i;
			}
			last = next;
		}
		
		return a;
	}
}

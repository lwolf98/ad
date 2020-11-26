package exc_6.sort.algorithms;

public class CountSortIdea extends SortAlgorithm {	
	public int k;
	
	public CountSortIdea(int k) {
		this.k = k;
	}
	
	public int[] sort(int[] a) {
		int j;
		int n = a.length;
		int[] bin = new int[k + 1];
		
		//for(int i = 1; i <= k; i++)
		//	bin[i] = 0;
		
		for(int i = 0; i < n; i++)
			bin[a[i]] += a[i];
		
		int max = 0;
		for(int i = k; i >= 1; i--)
			if(bin[i] != 0) {
				max = i;
				break;
			}
		
		int last = 0;
		for(int i = 1; i <= k; i++) {
			if(bin[i] != 0) {
				bin[i] += last;
				last = i;
			}
		}
		
		j = max;
		for(int i = n - 1; i >= 0; i--) {			
			a[i] = j;
			bin[j] -= j;
			
			if(bin[j] < j)
				j = bin[j];
		}
		
		return a;
	}
}

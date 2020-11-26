package exc_6.sort.algorithms;

public class MapSort extends SortAlgorithm {
	public double c;
	
	public MapSort(double c) {
		this.c = c;
	}
	
	@Override
	public int[] sort(int[] a) {
		int n = a.length;
		
		int newn = (int) (n * c);
		int[] bin = new int[newn];
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < newn; i++)
			bin[i] = -1;
		
		for(int i = 0; i < n; i++) {
			if(a[i] < min)
				min = a[i];
			
			if(a[i] > max)
				max = a[i];
		}
		
		double dist = (double)(max - min) / (newn - 1);
		for(int i = 0; i < n; i++) {
			int t = (int) ((double) (a[i] - min) / dist);
			int insert = a[i];
			int left = 0;
			if(bin[t] != -1 && insert <= bin[t])
				left = 1;
			
			while(bin[t] != -1) {
				if(left == 1) {
					if(insert > bin[t]) {
						int tmp = bin[t];
						bin[t] = insert;
						insert = tmp;
					}
					if(t > 0) t--;
					else left = 0;
				} else {
					if(insert <= bin[t]) {
						int tmp = bin[t];
						bin[t] = insert;
						insert = tmp;
					}
					if(t < newn - 1) t++;
					else left = 1;
				}
			}
			
			bin[t] = insert;
		}
		
		int j = 0;
		for(int i = 0; i < newn; i++)
			if(bin[i] != -1)
				a[j++] = bin[i];
		
		return a;
	}
}

package exc_4.sort.algorithms;

public abstract class QuickSortBase extends SortAlgorithm {
	public int count;
	
	public QuickSortBase() {
		count = 0;
	}
	
	protected int preparePartition(int[] a, int f, int l) {
		int pivot = a[f];
		int p = f; //- 1;
		
		for(int i = f + 1; i <= l; i++) { //"i=f+1" statt "i=f"
			count++;
			if(a[i] < pivot) { //"<" statt "<="
				p++;
				swap(a, i, p);
			}
		}
		
		swap(a, f, p);
		return p;
	}
}

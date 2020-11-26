package exc_6.sort.algorithms;

public class HeapSort extends SortAlgorithm {

	@Override
	public int[] sort(int[] a) {
		int f = 0;
		int l = a.length - 1;
		buildHeap(a, f, l);
		
		for(int i = l; i > f; i--) {
			swap(a, f, i);
			heapify(a, f, i - 1, f);
		}
		
		return a;
	}
	
	private void buildHeap(int[] a, int f, int l) {
		int n = l - f + 1;
		
		for(int i = f + (n - 2) / 2; i >= f; i--)
			heapify(a, f, l, i);
	}
	
	private void heapify(int[] a, int f, int l, int root) {
		int largest;
		int left = f + (root - f) * 2 + 1;
		int right = f + (root - f) * 2 + 2;
		if(left <= l && a[left] >a[root])
			largest = left;
		else
			largest = root;
		
		if(right <= l && a[right] > a[largest])
			largest = right;
		
		if(largest != root) {
			swap(a, root, largest);
			heapify(a, f, l, largest);
		}
	}
}

package exc_6.sort.algorithms.generic;

public class HeapSort extends SortAlgorithm {

	@Override
	public <T extends Comparable<T>> void sort(T[] a) {
		int f = 0;
		int l = a.length - 1;
		buildHeap(a, f, l);
		
		for(int i = l; i > f; i--) {
			swap(a, f, i);
			heapify(a, f, i - 1, f);
		}
	}
	
	private <T extends Comparable<T>> void buildHeap(T[] a, int f, int l) {
		int n = l - f + 1;
		
		for(int i = f + (n - 2) / 2; i >= f; i--)
			heapify(a, f, l, i);
	}
	
	private <T extends Comparable<T>> void heapify(T[] a, int f, int l, int root) {
		int largest;
		int left = f + (root - f) * 2 + 1;
		int right = f + (root - f) * 2 + 2;
		if(left <= l && a[left].compareTo(a[root]) > 0)
			largest = left;
		else
			largest = root;
		
		if(right <= l && a[right].compareTo(a[largest]) > 0)
			largest = right;
		
		if(largest != root) {
			swap(a, root, largest);
			heapify(a, f, l, largest);
		}
	}
}

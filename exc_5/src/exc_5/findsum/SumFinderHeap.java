package exc_5.findsum;

import exc_5.sort.algorithms.SortAlgorithm;

public class SumFinderHeap extends SortAlgorithm {
	private int s;
	private boolean sFound;
	
	public boolean findSum(int[] a, int s) {
		this.s = s;
		sFound = false;
		
		sort(a);
		
		/*if(sFound)
			System.out.println("Found sum: " + s);
		else
			System.out.println("Did not find sum: " + s);*/
		
		return sFound;
	}
	
	@Override
	public void sort(int[] a) {
		int f = 0;
		int l = a.length - 1;
		buildHeap(a, f, l);
		
		for(int i = l; i > f; i--) {
			swap(a, f, i);
			heapify(a, f, i - 1, f);
		}
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
		
		if(left <= l && a[root] + a[left] == s)
			sFound = true;
		
		if(right <= l && (a[root] + a[right] == s || a[right] + a[left] == s))
			sFound = true;
		
		if(left <= l && a[left] > a[root])
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

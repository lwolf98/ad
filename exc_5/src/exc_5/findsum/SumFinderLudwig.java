package exc_5.findsum;

import exc_5.sort.algorithms.MergeSort;

public class SumFinderLudwig {
	public boolean findSum(int[] a, int s) {
		int n = a.length;
		
		new MergeSort().sort(a);
		
		int left = 0;
		int right = n - 1;
		while(left < right) {
			int sum = a[left] + a[right];
			if(sum == s)
				return true;
			else if(sum > s)
				right--;
			else if(sum < s)
				left++;

		}
		
		return false;
	}
}

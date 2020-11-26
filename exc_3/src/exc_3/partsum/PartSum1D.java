package exc_3.partsum;

public class PartSum1D {
	public static int maxPartSum(int arr[]) {
		int max = Integer.MIN_VALUE;
		int curSum = 0;
		
		for(int i = 0; i < arr.length; i++) {
			int s = curSum + arr[i];
			if(s > arr[i])
				curSum = s;
			else
				curSum = arr[i];
			
			if(curSum > max)
				max = curSum;
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		int[] arr = {-13, 25, 34, 12, -3, 7, -87, 28, -77, 11};
		System.out.println("Max part sum: " + maxPartSum(arr));
	}
}

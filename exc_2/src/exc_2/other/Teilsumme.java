package exc_2.other;

public class Teilsumme {
	public static void main(String[] args) {
		int[] arr = {-13, 25, 34, 12, -3, 7, -87, 28, -77, 11};
		teilsumme(arr);
		System.out.println("Max: " + teilsumme2(arr));
	}
	
	public static void teilsumme(int[] arr) {
		int max = Integer.MIN_VALUE;
		int s = 0;
		int start = 0;
		int end = 0;
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = i; j < arr.length; j++) {
				s += arr[j];
				if(s > max) {
					start = i;
					end = j;
					max = s;
				}
			}
			
			s = 0;
		}
		
		System.out.println("Max: " + max + " bei Start: " + start + " und Ende: " + end);
	}
	
	public static int teilsumme2(int[] arr) {
		int max = Integer.MIN_VALUE;
		int sum = 0;
		
		for(int i = 0; i < arr.length; i++) {
			if(sum + arr[i] > arr[i])
				sum = sum + arr[i];
			else
				sum = arr[i];
			
			if(sum > max)
				max = sum;
		}
		
		return max;
	}
}
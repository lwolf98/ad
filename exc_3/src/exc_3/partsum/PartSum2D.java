package exc_3.partsum;

import java.util.Random;

public class PartSum2D {
	
	//Brute force Variante
	public static int maxPartSum1(int[][] arr) {
		int max = Integer.MIN_VALUE;
		int sum = 0;
		int n = arr.length;
		int is_m = 0, js_m = 0, ie_m = 0, je_m = 0;
		
		for(int is = 0; is < n; is++) {
			for(int js = 0; js < n; js++) {
				for(int ie = is; ie < n; ie++) {
					for(int je = js; je < n; je++) {
						
						for(int y = js; y <= je; y++) {
							for(int x = is; x <= ie; x++) {
								sum += arr[y][x];
							}
						}
						if(sum > max) {
							max = sum;
							is_m = is;
							js_m = js;
							ie_m = ie;
							je_m = je;
						}

						sum = 0;
					}
				}
			}
		}
		
		System.out.printf("(1): From (%d|%d) to (%d|%d), Sum: %d\n", is_m, js_m, ie_m, je_m, max);
		
		return max;
	}
	
	//O(n³) Variante
	public static int maxPartSum2(int[][] arr) {
		int n = arr.length;
		int max = Integer.MIN_VALUE;
		int[] sum = new int[n];
		int is_tmp = 0;
		int is_m = 0, js_m = 0, ie_m = 0, je_m = 0;
		
		for(int j1 = 0; j1 < n; j1++) {
			for(int i = 0; i < n; i++)
				sum[i] = 0;
			
			for(int j2 = j1; j2 < n; j2++) {
				int part_sum = 0;
				for(int i = 0; i < n; i++) {
					sum[i] += arr[i][j2];
					if(part_sum + sum[i] > sum[i]) {
						part_sum += sum[i];
					} else {
						part_sum = sum[i];
						is_tmp = i;
					}
					
					if(part_sum > max) {
						max = part_sum;
						is_m = is_tmp;
						ie_m = i;
						js_m = j1;
						je_m = j2;
					}
				}
			}
		}

		System.out.printf("(2): From (%d|%d) to (%d|%d), Sum: %d\n", js_m, is_m, je_m, ie_m, max);
		
		return max;
	}
	
	public static void main(String[] args) {
		int n = 10;
		int[][] arr = new int[n][n];
		int[][] arr2 = 
			{
				{6, -5, -7, 4},
				{-9, 3, -6, 5},
				{-10, 4, 7, -6},
				{-8, 9, -3, 3},
			};
		
		Random rnd = new Random();
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				arr[i][j] = rnd.nextInt(10) - 5;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.printf("%4s", arr[i][j]);
			}
			System.out.println();
		}
		
		System.out.println();
		
		//Berechnung in statisch festgelegtem Array
		maxPartSum1(arr2);
		maxPartSum2(arr2);
		
		System.out.println();
		
		//Berechnung in zufällig bestimmtem Array
		maxPartSum1(arr);
		maxPartSum2(arr);
	}
}

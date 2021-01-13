package exc_12.algorithms;

import static exc_12.util.MatrixUtils.*;

public class FloydWarshall {
	private static final int PRINT_WIDTH = 4;
	
	public static void main(String[] args) {
		int inf = Integer.MAX_VALUE;
		int[][] w = 
			{
				{0, inf, inf, inf, -1, inf},
				{1, 0, inf, 2, inf, inf},
				{inf, 2, 0, inf, inf, -8},
				{-4, inf, inf, 0, 3, inf},
				{inf, 7, inf, inf, 0, inf},
				{inf, 5, 10, inf, inf, 0}
			};
		
		floydWarshall(w);
	}
	
	private static int[][] floydWarshall(int[][] w) {
		int n = w.length;
		int[][] dk_prev = w;
		
		System.out.println("D0:");
		printMatrix(dk_prev, PRINT_WIDTH);
		
		int[][] dk = null;
		for(int k = 0; k < n; k++) {
			dk = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					dk[i][j] = Math.min(dk_prev[i][j], addInf(dk_prev[i][k], dk_prev[k][j]));
				}
			}
			dk_prev = dk;
			System.out.println("D" + (k + 1) + ":");
			printMatrix(dk, PRINT_WIDTH);
		}
		
		return dk;
	}
}

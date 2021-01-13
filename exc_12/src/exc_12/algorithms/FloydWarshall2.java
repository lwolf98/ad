package exc_12.algorithms;

import static exc_12.util.MatrixUtils.*;

public class FloydWarshall2 {
	private static final int PRINT_WIDTH = 4;
	
	private int[][] w;
	private int[][][] d;
	
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
		
		new FloydWarshall2(w).calculate();
	}
	
	public FloydWarshall2(int[][] w) {
		this.w = w;
	}
	
	private int[][] calculate() {
		int n = w.length;
		d = new int[n+1][n][n];
		
		//int[][] dk_prev = w;
		d[0] = w;
		
		System.out.println("D0:");
		printMatrix(d[0], PRINT_WIDTH);
		
		//int[][] dk = null;
		for(int k = 1; k <= n; k++) {
			d[k] = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					d[k][i][j] = Math.min(d[k-1][i][j], addInf(d[k-1][i][k-1], d[k-1][k-1][j]));
				}
			}
			System.out.println("D" + k + ":");
			printMatrix(d[k], PRINT_WIDTH);
		}
		
		return d[n-1];
	}
}

package exc_12.algorithms;

import static exc_12.util.MatrixUtils.*;

public class APSP {
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
		
		apsp(w);
	}
	
	private static int[][] apsp(int[][] w) {
		int n = w.length;
		
		System.out.println("L1:");
		printMatrix(w, PRINT_WIDTH);
		
		int[][] lm = w;
		for(int m = 2; m < n; m++) {
			lm = extendShortestPaths(lm, w);
			System.out.println("L" + m + ":");
			printMatrix(lm, PRINT_WIDTH);
		}
		
		return lm;
	}
	
	private static int[][] extendShortestPaths(int[][] l, int[][] w) {
		int n = l.length;
		int[][] l_new = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				l_new[i][j] = Integer.MAX_VALUE;
				for(int k = 0; k < n; k++) {
					l_new[i][j] = Math.min(l_new[i][j], addInf(l[i][k], w[k][j]));
				}
			}
		}
		
		return l_new;
	}
}

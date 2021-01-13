package exc_12.util;

public class MatrixUtils {
	public static void printMatrix(int[][] m, int width) {
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[0].length; j++) {
				String x = m[i][j] == Integer.MAX_VALUE ? "-" : Integer.toString(m[i][j]);
				System.out.printf("%" + width + "s", x);
			}
			
			System.out.println();
		}
		
		System.out.println();
	}
	
	public static int addInf(int a, int b) {
		if(a == Integer.MAX_VALUE || b == Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		
		return a + b;
	}
}

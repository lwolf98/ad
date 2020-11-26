package exc_4.matrix;

import java.util.Random;
import java.util.Scanner;

import exc_4.timer.Timer;
import exc_4.timer.Timer.OutputType;

public class Matrix {
	private static String opRunning;
	public static boolean showLog = false;
	public static OutputType typeOut = OutputType.Nanosecond;
	private static long lastDuration = 0;
	
	public int[][] table;
	private Random rnd;
	private Scanner scan;
	
	public Matrix(int rows, int cols) {
		table = new int[rows][cols];
		rnd = new Random();
		scan = new Scanner(System.in);
	}
	
	public void init() {
		for(int y = 0; y < getRows(); y++)
			for(int x = 0; x < getColumns(); x++)
				table[y][x] = 0;
	}
	
	public void print() {
		for(int y = 0; y < getRows(); y++) {
			for(int x = 0; x < getColumns(); x++)
				System.out.print(table[y][x] + " ");
			
			System.out.println();
		}
		System.out.println();
	}
	
	public void input() {
		for(int y = 0; y < getRows(); y++) {
			for(int x = 0; x < getColumns(); x++) {
				System.out.println("Position (" + x + "|" + y + ") eingeben:");
				table[y][x] = scan.nextInt();
			}
		}
	}
	
	public void randomFill() {
		for(int y = 0; y < getRows(); y++)
			for(int x = 0; x < getColumns(); x++)
				table[y][x] = rnd.nextInt(10);
	}
	
	public int getRows() {
		return table.length;
	}
	
	public int getColumns() {
		return table[0].length;
	}
	
	public static Matrix sub(Matrix m1, Matrix m2) {
		return add(m1, m2, -1);
	}
	
	public static Matrix add(Matrix m1, Matrix m2) {
		return add(m1, m2, 1);
	}
	
	private static Matrix add(Matrix m1, Matrix m2, int operation) {
		if(m1.getColumns() != m2.getColumns() || m1.getRows() != m2.getRows())
			return null;

		String op = new Object(){}.getClass().getEnclosingMethod().getName();
		startTimer(op);
		
		if(opRunning == null)
			opRunning = Matrix.class.getEnclosingMethod().getName();
		
		int cols = m1.getColumns();
		int rows = m2.getRows();
		
		Matrix mResult = new Matrix(rows, cols);
		
		for(int y = 0; y < rows; y++)
			for(int x = 0; x < cols; x++)
				mResult.table[y][x] = m1.table[y][x] + operation * m2.table[y][x];
		
		if(showLog && op.equals(opRunning)) {
			stopTimer(op);
			System.out.println("Log (" + op + "):");
			lastDuration = Timer.stopTimer(typeOut);
			System.out.println("Duration (" + typeOut + "): " + lastDuration);
			System.out.println("Operations: " + (long)rows * cols);
		}
		
		return mResult;
	}
	
	public static Matrix mult(Matrix m1, Matrix m2) {
		if(m1.getColumns() != m2.getRows())
			return null;
		
		String op = new Object(){}.getClass().getEnclosingMethod().getName();
		startTimer(op);
		
		int colsResult = m2.getColumns();
		int rowsResult = m1.getRows();
		
		int lengthSum = m1.getColumns();
		
		Matrix mResult = new Matrix(rowsResult, colsResult);
		
		for(int yRes = 0; yRes < rowsResult; yRes++)
			for(int xRes = 0; xRes < colsResult; xRes++)
				for(int i = 0; i < lengthSum; i++)
					mResult.table[yRes][xRes] += m1.table[yRes][i] * m2.table[i][xRes];

		if(showLog && op.equals(opRunning)) {
			stopTimer(op);
			
			System.out.println("Log (" + op + "):");
			System.out.println("Duration (" + typeOut + "): " + lastDuration);
		}
		
		return mResult;
	}
	
	public static Matrix mult_var2(Matrix m, Matrix n) {
		if(!(m.getColumns() == m.getRows() && m.getRows() == n.getColumns() && n.getColumns() == n.getRows()))
			return null;
		
		int size = m.getColumns();
		double d = Math.log(size) / Math.log(2);
		if(d - (int)d != 0)
			return null;

		String op = new Object(){}.getClass().getEnclosingMethod().getName();
		startTimer(op);
		
		Matrix res = mult_rec(m, n);

		if(showLog && op.equals(opRunning)) {
			stopTimer(op);
			System.out.println("Log (" + op + "):");
			System.out.println("Duration (" + typeOut + "): " + lastDuration);
		}
		
		return res;
	}
	
	private static Matrix mult_rec(Matrix m, Matrix n) {
		int size = m.getColumns();
		
		if(size <= 128 ) {
			return mult(m, n);
		}
		
		Matrix[][] m4 = new Matrix[2][2];
		Matrix[][] n4 = new Matrix[2][2];
		for(int y = 0; y < 2; y ++) {
			for(int x = 0; x < 2; x++) {
				m4[y][x] = quarterMatrix(m, y, x);
				n4[y][x] = quarterMatrix(n, y, x);
			}
		}
		
		Matrix[] h = new Matrix[7];
		h[0] = mult_rec(add(m4[0][0], m4[1][1]), add(n4[0][0], n4[1][1]));
		h[1] = mult_rec(add(m4[1][0], m4[1][1]), n4[0][0]);
		h[2] = mult_rec(m4[0][0], sub(n4[0][1], n4[1][1]));
		h[3] = mult_rec(m4[1][1], sub(n4[1][0], n4[0][0]));
		h[4] = mult_rec(add(m4[0][0], m4[0][1]), n4[1][1]);
		h[5] = mult_rec(sub(m4[1][0], m4[0][0]), add(n4[0][0], n4[0][1]));
		h[6] = mult_rec(sub(m4[0][1], m4[1][1]), add(n4[1][0], n4[1][1]));
		
		Matrix o1 = add(sub(add(h[0], h[3]), h[4]), h[6]);
		Matrix o2 = add(h[2], h[4]);
		Matrix o3 = add(h[1], h[3]);
		Matrix o4 = add(add(sub(h[0], h[1]), h[2]), h[5]);
		
		return combineQuarters(new Matrix[] {o1, o2, o3, o4});
	}
	
	private static Matrix quarterMatrix(Matrix m, int posRows, int posCols) {
		int half = m.getColumns() / 2;
		Matrix mQuart = new Matrix(half, half);
		
		for(int y = 0; y < half; y++)
			for(int x = 0; x < half; x++)
				mQuart.table[y][x] = m.table[half * posRows + y][half * posCols + x];
		
		return mQuart;
	}
	
	private static Matrix combineQuarters(Matrix[] arrM) {
		int half = arrM[0].getColumns();
		int size = half * 2;
		Matrix m = new Matrix(size, size);
		
		for(int i = 0; i < 2; i++)
			for(int j = 0; j < 2; j++)
				for(int y = 0; y < half; y++)
					for(int x = 0; x < half; x++)
						m.table[i * half + y][j * half + x] = arrM[i * 2 + j].table[y][x];
		
		return m;
	}
	
	public static long getDurationOfLastOperation() {
		return lastDuration;
	}
	
	private static void startTimer(String operation) {
		if(opRunning == null) {
			opRunning = operation;
			Timer.startTimer();
		}
	}
	
	private static void stopTimer(String operation) {
		if(operation.equals(opRunning)) {
			opRunning = null;
			lastDuration = Timer.stopTimer(typeOut);
		}
	}
}

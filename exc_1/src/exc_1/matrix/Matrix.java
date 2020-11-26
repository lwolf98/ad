package exc_1.matrix;

import java.util.Random;
import java.util.Scanner;

import exc_1.timer.Timer;
import exc_1.timer.Timer.OutputType;

public class Matrix {
	public static boolean showLog = false;
	public static OutputType typeOut = OutputType.Nanosecond;
	private static long lastDuration = 0;
	
	private int[][] table;
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
	
	public static Matrix add(Matrix m1, Matrix m2) {
		if(m1.getColumns() != m2.getColumns() || m1.getRows() != m2.getRows())
			return null;
		
		Timer.startTimer();
		
		int cols = m1.getColumns();
		int rows = m2.getRows();
		
		Matrix mResult = new Matrix(rows, cols);
		
		for(int y = 0; y < rows; y++)
			for(int x = 0; x < cols; x++)
				mResult.table[y][x] = m1.table[y][x] + m2.table[y][x];
		
		if(showLog) {
			System.out.println("Log add:");
			lastDuration = Timer.stopTimer(typeOut);
			System.out.println("Duration (" + typeOut + "): " + lastDuration);
			System.out.println("Operations: " + (long)rows * cols);
		}
		
		return mResult;
	}
	
	public static Matrix mult(Matrix m1, Matrix m2) {
		if(m1.getColumns() != m2.getRows())
			return null;
		
		Timer.startTimer();
		
		int colsResult = m2.getColumns();
		int rowsResult = m1.getRows();
		
		int lengthSum = m1.getColumns();
		
		Matrix mResult = new Matrix(rowsResult, colsResult);
		
		for(int yRes = 0; yRes < rowsResult; yRes++)
			for(int xRes = 0; xRes < colsResult; xRes++)
				for(int i = 0; i < lengthSum; i++)
					mResult.table[yRes][xRes] += m1.table[yRes][i] * m2.table[i][xRes];
		
		if(showLog) {
			lastDuration = Timer.stopTimer(typeOut);
			
			System.out.println("Log mult:");
			System.out.println("Duration (" + typeOut + "): " + lastDuration);
			long operations = (long)rowsResult * colsResult * lengthSum;
			System.out.println("Operations: " + operations);
			System.out.println("Average duration 1 operation: " + (Timer.getLastDeltaNs() / operations) + "ns");
		}
		
		return mResult;
	}
	
	public static long getDurationOfLastOperation() {
		return lastDuration;
	}
}

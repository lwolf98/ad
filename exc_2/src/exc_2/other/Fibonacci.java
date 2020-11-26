package exc_2.other;

public class Fibonacci {
	public static void main(String[] args) {
		System.out.println(fib(9));
	}
	
	public static int fib(int n) {
		if(n < 1)
			return -1;
		
		if(n == 1 || n == 2)
			return 1;
		
		return fib(n - 1) + fib(n - 2);
	}
}

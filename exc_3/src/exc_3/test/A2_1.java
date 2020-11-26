package exc_3.test;

public class A2_1 {
	public static int t(int n) {
		if(n <= 1)
			return 1;
		
		return 4 * t(n/2) + n;
	}
	
	public static int t_sum(int n) {
		int sum = 0;
		for(int i = 0; i < Math.log10(n) / Math.log10(2); i++)
			sum += Math.pow(2, i);
		
		return n*n + sum * n;
		
	}
	
	public static int t_poly(int n) {
		return 2 * n*n - n;
	}
	
	public static void main(String[] args) {
		System.out.println("t()");
		for(int i = 2; i <= 64; i *= 2)
			System.out.println(t(i));

		System.out.println("\nt_sum()");
		for(int i = 2; i <= 64; i *= 2)
			System.out.println(t_sum(i));

		System.out.println("\nt_poly()");
		for(int i = 2; i <= 64; i *= 2)
			System.out.println(t_poly(i));
	}
}

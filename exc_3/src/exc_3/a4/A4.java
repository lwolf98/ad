package exc_3.a4;

import java.util.Stack;

public class A4 {
	
	//rekursive Variante
	public static int f(int n, int m) {
		if(n < 0 || m < 0)
			return -1;
		
		if(n == 0)
			return m + 1;
		
		if(m == 0 && n >= 1)
			return f(n - 1, 1);
		
		return f(n - 1, f(n, m - 1));
	}
	
	//iterative Variante
	/*
	 * rekursive Variante wird imitiert
	 * => ähnliche Zeitkomplexität, aber deutlich bessere Speicherkapazität (in Abhängigkeit von n, m),
	 * da der Stack nicht so schnell "überläuft", wie bei einer Rekursion.
	 */
	public static int f2(int n, int m) {
		boolean debug = true;
		
		Stack<Integer> stack = new Stack<Integer>();
		long cnt = 0;
		
		while(true) {
			if(debug) {
				if(++cnt % 1000000000 == 0)
					System.out.println("Count: " + cnt + ", Stack size: " + stack.size());
				
			}
			
			if(n == 0) {
				m++;
				if(stack.empty())
					return m;
				
				n = stack.pop();
				continue;
			}
			
			if(m == 0 && n >= 1) {
				n--;
				m = 1;
				continue;
			}
			
			stack.push(n - 1);
			m--;
		}
	}
	
	public static void main(String[] args) {
		
		for(int n = 0; n <= 3; n++)
			for(int m = 0; m <= 100; m++)
				System.out.printf("(%d, %d) -> %d\n", n, m, f2(n, m));
		
		/*
		 * Möglichst hohe Werte:
		 * f(4, 1) = 65533
		 * f(3, 13) = 65533
		 * f(3, 14) = 131069
		 * f(3, 15) = 262141
		 * f(3, 16) = 524285
		 */
	}
}

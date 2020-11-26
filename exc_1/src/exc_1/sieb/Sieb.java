package exc_1.sieb;

public class Sieb {
	public static void sieb(int k) {
		//The array index represents the corresponding number.
		//E. g. The number 2 is a prime. Therefore index 2 of arrPrime will be set to true.
		//The length is set to (k + 1) to reach the last relevant number.
		boolean[] arrPrime = new boolean[k + 1];
		
		arrPrime[0] = false;
		arrPrime[1] = false;
		for(int i = 2; i <= k; i++)
			arrPrime[i] = true;
		
		for(int i = 2; i <= k; i++) {
			if(arrPrime[i] == false)
				continue;
			
			for(int j = i + i; j <= k; j += i)
				arrPrime[j] = false;
			
		}
		
		printAllMarkPrimes(arrPrime);
		printPrimesOnly(arrPrime);
	}
	
	private static void printAllMarkPrimes(boolean[] arrPrime) {
		int digits = Integer.toString(arrPrime.length - 1).length() + 2 + 1;
		
		System.out.println("Table (numbers in braces are primes):");
		for(int i = 1; i < arrPrime.length; i++) {
			String output;
			
			if(arrPrime[i])
				output = "[" + i + "]";
			else
				 output = i + " ";
			
			System.out.print(String.format("%" + digits + "s", output));
			
			if(i % 10 == 0)
				System.out.println();
		}
	}
	
	private static void printPrimesOnly(boolean[] arrPrime) {
		int digits = Integer.toString(arrPrime.length - 1).length() + 1;
		
		System.out.println("\nList primes only:");
		int primeCount = 0;
		for(int i = 1; i < arrPrime.length; i++) {
			if(arrPrime[i]) {
				primeCount++;
				System.out.print(String.format("%" + digits + "s", i + " "));
				
				if(primeCount % 15 == 0)
					System.out.println();
			}
		}
	}
	
	public static void main(String[] args) {
		sieb(100000);
	}
}

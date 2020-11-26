package exc_6.lotto;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Random;

public class Lotto {
	public static int[] zahlenZiehen() {
		Queue<Integer> numbers = new ArrayDeque<Integer>();
		for(int i = 1; i <= 49; i++)
			numbers.offer(i);

		int[] result = new int[6];
		Random rnd = new Random();
		for(int i = 0; i < result.length; i++) {
			int lenNumbers = numbers.size();
			int step = rnd.nextInt(lenNumbers);
			
			for(int j = 0; j < step; j++)
				numbers.offer(numbers.poll());
			
			result[i] = numbers.poll();
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] resultCount = new int[50];
		for(int i = 0; i < 100000; i++) {
			int[] result = Lotto.zahlenZiehen();
			System.out.println(Arrays.toString(result));
			
			for(int j = 0; j < result.length; j++)
				resultCount[result[j]]++;
			
		}
		
		System.out.println(Arrays.toString(resultCount));
	}
}

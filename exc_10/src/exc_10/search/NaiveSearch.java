package exc_10.search;

public class NaiveSearch {
	public static int naiveSearch(char[] text, char[] muster) {
		int n = text.length;
		int m = muster.length;
		int loops = 0;
		
		int count = 0;
		for(int i = 0; i <= n - m; i++) {
			boolean match = true;
			for(int j = 0; j < m; j++) {
				loops++;
				if(text[i + j] != muster[j]) {
					match = false;
					break;
				}
			}
			if(match)
				count++;
		}
		
		System.out.println("Loops: " + loops);
		return count;
	}
	
	/**
	 * A3:
	 * NaiveSearch: T = O(n)
	 */
	public static int naiveSearchLinear(char[] text, char[] muster) {
		int n = text.length;
		int m = muster.length;
		int loops = 0;
		
		int count = 0;
		for(int i = 0; i <= n - m; i++) {
			boolean match = true;
			int j;
			for(j = 0; j < m; j++) {
				loops++;
				//System.out.println("Compare: " + text[i + j] + " = " + muster[j] + "?");
				if(text[i + j] != muster[j]) {
					match = false;
					break;
				}
			}

			i += j;
			
			if(match) {
				count++;
				i--;
			}
		}

		System.out.println("Loops: " + loops);
		return count;
	}
}

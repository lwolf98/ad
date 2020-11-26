package exc_5.findsum;

public class SumFinderBasic {
	public boolean findSum(int[] a, int s) {
		int n = a.length;
		
		for(int j = 1; j < n; j++)
			for(int i = 0; i < j; i++)
				if(a[i] + a[j] == s)  {
					//System.out.printf("(a[%d] = %d) + (a[%d] = %d) = %d\n", i, a[i], j, a[j], s);
					return true;
				}
		
		//System.out.println("Sum " + s + " not found");
		return false;
	}
}

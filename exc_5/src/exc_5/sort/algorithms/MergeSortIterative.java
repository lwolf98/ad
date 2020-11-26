package exc_5.sort.algorithms;

/**
 * Laufzeitanalyse:
 * - Schleife über Levels (ohne Operationen): O(log(n))
 * - while-Schleife:
 * 		=> ist abhängig von for-Schleife in merge()
 * 		=> Insgesamt werden mit beiden Schleifen jeweils alle Teil-Arrays eines Levels durchlaufen
 * 		=> Somit eine Laufzeit von O(n)
 * 
 * - Die Schleifen sind geschachtelt => Laufzeit: O(n log(n))
 * - Bei Betrachten der unteren Schranke => Laufzeit: Theta(n log(n))
 * 
 */
public class MergeSortIterative extends SortAlgorithm {
	@Override
	public void sort(int[] a) {
		int n = a.length;
		int l_global = n - 1;
		if(n == 0)
			return;
		
		int levels = (int) Math.ceil(Math.log(n) / Math.log(2));
		
		int span = 2;
		for(int i = 0; i < levels; i++) {
			int f = 0;
			
			boolean levelDone = false;
			while(!levelDone) {
				int l = f + span - 1;
				
				//'m' will be bigger than l_global sometimes.
				//The behavior for an out of bounds 'm' will be correctly handled by merge().
				int m = (f + l + 1) / 2;
				if(l > l_global)
					l = l_global;
				
				merge(a, f, l, m);
				
				f += span;
				if(f > l_global)
					levelDone = true;
			}
			
			span *= 2;
		}
	}
	
	private void merge(int[] a, int f, int l, int m) {
		int n = l - f + 1;
		int a1f = f, a1l = m - 1;
		int a2f = m, a2l = l;
		int[]aNew = new int[n];
		
		for(int i = 0; i < n; i++) {
			if(a1f <= a1l) {
				if(a2f <= a2l) {
					if(a[a1f] <= a[a2f]) aNew[i] = a[a1f++];
					else aNew[i] = a[a2f++];
				} else aNew[i] = a[a1f++];
			} else aNew[i] = a[a2f++];
		}
		
		for(int i = 0; i < n; i++)
			a[f + i] = aNew[i];
	}
}

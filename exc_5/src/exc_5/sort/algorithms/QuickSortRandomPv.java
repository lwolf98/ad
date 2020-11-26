package exc_5.sort.algorithms;

import java.util.Random;

public class QuickSortRandomPv extends QuickSortBase {
	private Random rnd;
	
	public QuickSortRandomPv() {
		rnd = new Random();
	}
	
	/**
	 * Der Algorithmus in dieser Variante ist fast identisch zur
	 * Ursprungsvariante.
	 * Der einzige Unterschied ist die Berechnung eines zuf�lligen
	 * Indexes und das anschliedende Tauschen mit der ersten Position.
	 * Daher wird die Funktionalit�t in der Korrektheit nicht eingeschr�nkt.
	 * Die Laufzeit ist um einen "kleinen" konstanten Aufwand je
	 * Rekursionsaufruf erh�ht.
	 * (Annahme: nextint() von Random hat eine konstante Laufzeit unabh�ngig
	 * von den Parametern.)
	 */
	@Override
	public void sort(int[] a) {
		quickSort(a, 0, a.length - 1);
	}
	
	private void quickSort(int[] a, int f, int l) {
		if(f < l) {
			int rndPos = rnd.nextInt(l - f + 1) + f;
			swap(a, f, rndPos);
			
			int part = preparePartition(a, f, l);
			quickSort(a, f, part - 1);
			quickSort(a, part + 1, l);
		}
	}
}

package exc_6.list;

/**
 * Speicherplatz:
 * - Konstant: Referenzen auf qSort, head, tail + size = 4
 * - von n abhängig: Referenz auf value und next von ListEntry = 2n
 * - Gesamt: etwa 2n + 4 -> O(n)
 * 
 * Laufzeit:
 * - Zeitkritische Abweichungen zum Array-Quicksort:
 * 		> getEntryAt() enthält eine Schleife, die im Worst Case bis n läuft.
 * 		> Die Methode wird in preparePartition() einmal (zeitkritisch) aufgerufen.
 * - Folglich wird die Laufzeit im Worst Case verdoppelt. (Zwei statt einer for(n)-Schleife)
 * - Die Klasse bleibt aber in jedem Fall Theta(n log(n))
 *
 */
public class QuickSortLinkedList <T extends Comparable<T>> {
	public void sort(LinkedList<T> lst) {
		quickSort(lst, 0, lst.size() - 1);
	}
	
	private void quickSort(LinkedList<T> lst, int f, int l) {
		if(f < l) {
			int part = preparePartition(lst, f, l);
			quickSort(lst, f, part - 1);
			quickSort(lst, part + 1, l);
		}
	}
	
	private int preparePartition(LinkedList<T> lst, int f, int l) {
		ListEntry<T> entry_p = lst.getEntryAt(f - 1);
		ListEntry<T> entry_f = (entry_p == null) ? lst.getEntryAt(f) : entry_p.next;
		
		ListEntry<T> pivot = entry_f;
		int p = f - 1;
		
		ListEntry<T> cur = entry_f;
		for(int i = f; i <= l; i++) {
			if(cur.value.compareTo(pivot.value) <= 0) {
				p++;
				entry_p = (entry_p == null) ? entry_f : entry_p.next;
				
				swap(cur, entry_p);
				lst.print();
			}
			cur = cur.next;
		}
		
		swap(entry_f, entry_p);
		return p;
	}
	
	private void swap(ListEntry<T> e1, ListEntry<T> e2) {
		T tmp = e1.value;
		e1.value = e2.value;
		e2.value = tmp;
	}
}

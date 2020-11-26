package exc_6.rucksack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Laufzeit: Theta(n log(n))
 * 		> kommt von Quicksort
 * 		> Das Füllen des Rucksacks bei sortierten Einträgen ist in linearer Zeit möglich.
 *
 * Algorithmus funktioniert nur für Version 1 (anteilig).
 * Für Version 2 (ganzzahlig) kann der (leicht modifizierte) Algorithmus falsche Ergebnisse liefern.
 * 
 * Beispiel:
 * Auswahl Items: {[V: 20, W: 1, R: 20,00], [V: 30, W: 10, R: 3,00]}
 * Max. Gewicht: 10
 * 
 * Dann würde mit dem (n log(n))-Algorithmus zunächst das Item mit "Value-Ratio" 20 eingefügt werden.
 * Damit passts das zweite Item nicht mehr hinein.
 * Der maximale Wert würde aber erzielt werden, wenn das Item mit "Value" 30 eingefügt wird.
 * 
 * Ein Algorithmus, der die Potenzmenge der Items berechnet und auswertet liefert immer die korrekte Lösung.
 * Dieser hat allerdings eine Laufzeit von O(2^n).
 * 
 */
public class TestProblem {
	public static void main(String[] args) {
		RucksackEntry[] items = {
				new RucksackEntry(4, 5),
				new RucksackEntry(10, 3),
				new RucksackEntry(2, 2),
				new RucksackEntry(4, 3),
				new RucksackEntry(4, 6),
				new RucksackEntry(2, 12),
				new RucksackEntry(4, 3),
				new RucksackEntry(15, 21)
		};
		
		Set<RucksackEntry> itemsSet = new HashSet<RucksackEntry>(Arrays.asList(items));

		Set<RucksackEntry> bestRucksackSuspect = Rucksack.packVar1ForVar2(10, items);
		Set<RucksackEntry> bestRucksackCorrect = Rucksack.packVar2(10, itemsSet);
		
		int entries = 5;
		Random r = new Random();
		
		for(int j = 0; j < 100; j++) {
			items = new RucksackEntry[entries];
			for(int i = 0; i < entries; i++)
				items[i] = new RucksackEntry(r.nextInt(100) + 1, r.nextInt(100) + 1);
			
			itemsSet = new HashSet<RucksackEntry>(Arrays.asList(items));
			
			bestRucksackSuspect = Rucksack.packVar1ForVar2(10, items);
			bestRucksackCorrect = Rucksack.packVar2(10, itemsSet);
			
			int sumSuspect = 0;
			int sumCorrect = 0;
			
			for(RucksackEntry e : bestRucksackSuspect)
				sumSuspect += e.value;
		
			for(RucksackEntry e : bestRucksackCorrect)
				sumCorrect += e.value;
			
			System.out.println("Sums: " + sumSuspect + ", " + sumCorrect);
			if(sumSuspect != sumCorrect) {
				System.out.println("Error!");
				System.out.println(Arrays.toString(items));
				for(RucksackEntry e : bestRucksackSuspect)
					System.out.println(e + " ");
				for(RucksackEntry e : bestRucksackCorrect)
					System.out.println(e + " ");
				
				break;
			}
		}
	}
}

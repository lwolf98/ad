package exc_6.rucksack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TestRucksack {
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
		
		System.out.println(Arrays.toString(items) + "\n");
		
		for(RucksackEntry item : Rucksack.pack(20, items))
			System.out.println(item);

		System.out.println(Arrays.toString(items) + "\n");
		System.out.println();
		
		Set<RucksackEntry> itemsSet = new HashSet<RucksackEntry>(Arrays.asList(items));
		Set<RucksackEntry> bestRucksack = Rucksack.packVar2(20, itemsSet);
		 
		int totalWeight = 0;
		for(RucksackEntry item : bestRucksack) {
			System.out.println(item);
			totalWeight += item.weight;
		}
		System.out.println("Total weight: " + totalWeight);
	}
}

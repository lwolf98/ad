package exc_6.rucksack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import exc_6.sort.algorithms.generic.HeapSort;

public class Rucksack {
	public static List<RucksackEntry> pack(int maxWeight, RucksackEntry[] items) {
		List<RucksackEntry> rucksack = new ArrayList<RucksackEntry>();
		int curWeight = 0;
		
		new HeapSort().sort(items);
		for(int i = items.length - 1; i >= 0; i--) {
			RucksackEntry item = items[i];
			packItem(item, curWeight, maxWeight);
			
			if(item.percentage > 0) {
				rucksack.add(item);
				curWeight += item.weight;
			}
			
			if(item.percentage < 1)
				break;
		}
		
		return rucksack;
	}
	
	private static double packItem(RucksackEntry item, int curWeight, int maxWeight) {
		item.percentage = 1;
		
		if(item.weight > maxWeight - curWeight)
			item.percentage = ((double)maxWeight - curWeight) / item.weight;
		
		return item.percentage;
	}
	
	/**
	 * Versuch Variante 1 für Variante 2 zu verwenden.
	 * Ergebnis: Rucksack wird nicht immer richtig gepackt.
	 */
	public static Set<RucksackEntry> packVar1ForVar2(int maxWeight, RucksackEntry[] items) {
		Set<RucksackEntry> rucksack = new HashSet<RucksackEntry>();
		int curWeight = 0;
		
		new HeapSort().sort(items);
		for(int i = items.length - 1; i >= 0; i--) {
			RucksackEntry item = items[i];
			
			if(curWeight + item.weight <= maxWeight) {
				rucksack.add(item);
				curWeight += item.weight;
			}
		}
		
		return rucksack;
	}
	
	public static Set<RucksackEntry> packVar2(int maxWeight, Set<RucksackEntry> items) {
		Set<Set<RucksackEntry>> itemsPowerSet = SetUtils.powerSet(items);
		Set<RucksackEntry> rucksack = new HashSet<RucksackEntry>();
		int maxValue = 0;
		
		for(Set<RucksackEntry> subSet : itemsPowerSet) {
			int value = 0;
			int weight = 0;
			for(RucksackEntry e : subSet) {
				value += e.value;
				weight += e.weight;
			}
			
			if(weight <= maxWeight && value > maxValue) {
				rucksack = subSet;
				maxValue = value;
			}
		}
		
		return rucksack;
	}
	
	public static Set<Set<RucksackEntry>> packVar2All(int maxWeight, Set<RucksackEntry> items) {
		Set<Set<RucksackEntry>> itemsPowerSet = SetUtils.powerSet(items);
		Set<Set<RucksackEntry>> rucksacks = new HashSet<Set<RucksackEntry>>();
		int maxValue = 0;
		
		for(Set<RucksackEntry> subSet : itemsPowerSet) {
			int value = 0;
			int weight = 0;
			for(RucksackEntry e : subSet) {
				value += e.value;
				weight += e.weight;
			}
			
			if(weight <= maxWeight && value >= maxValue) {
				rucksacks.add(subSet);
				maxValue = value;
			}
		}
		
		return rucksacks;
	}
	
	/*public static RucksackEntry[][] powerSet(RucksackEntry[] items) {
		int n = items.length;
		int entries = (int)Math.pow(2, n);
		RucksackEntry[][] powerSet = new RucksackEntry[entries][];
		
		int[] pointer;
		for(int i = 0; i < n; i++) {
			pointer = new int[i];
			
			while(pointer[0] <)
		}
	}*/
}

package exc_6.list;

import java.util.Arrays;

import exc_6.sort.algorithms.generic.QuickSort;

public class TestList {
	public static void main(String[] args) {
		System.out.println("\n----- Test Quicksort (Integer) -----");
		testIntList();
		System.out.println("\n----- Test Quicksort (String) ------");
		testStringList();
		System.out.println("\n----------- Test aus VL ------------");
		testVL();
	}
	
	private static void testIntList() {
		LinkedList<Integer> myList = new LinkedList<Integer>();
		
		myList.append(34);
		myList.append(45);
		myList.append(12);
		myList.append(34);
		myList.append(23);
		myList.append(18);
		myList.append(38);
		myList.append(17);
		myList.append(43);
		myList.append(7);
		myList.print();
		
		Integer[] a = {34, 45, 12, 34, 23, 18, 38, 17, 43, 7};
		new QuickSort().sort(a);
		System.out.println(Arrays.toString(a));
		
		myList.quickSort();
		myList.print();
		
		for(int i : myList)
			System.out.println("Entry value: " + i);
		
		System.out.println(myList.size());
	}
	
	private static void testStringList() {
		LinkedList<String> myList = new LinkedList<String>();
		myList.append("def");
		myList.append("ghi");
		myList.append("abc");
		
		myList.print();
		myList.quickSort();
		myList.print();
	}
	
	private static void testVL() {

		LinkedList<Integer> myList = new LinkedList<Integer>();
		
		myList.append(34);
		myList.append(17);
		myList.append(7);
		
		myList.deleteValue(34);
		myList.print();
		myList.append(7);
		myList.print();
		myList.deleteValue(34);
		myList.print();
		myList.deleteValue(7);
		myList.print();
		myList.deleteValue(17);
		myList.print();
		myList.deleteValue(5);
		myList.print();
	}
}

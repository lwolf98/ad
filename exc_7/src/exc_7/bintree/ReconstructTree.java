package exc_7.bintree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReconstructTree {
	private static class SubArr {
		public Integer[] arr;
		public int first;
		public int last;
		
		public SubArr(Integer[] arr, int first, int last) {
			this.arr = arr;
			this.first = first;
			this.last = last;
		}
	}
	
	public static void main(String[] args) {
		Integer[] aPre = {6, 3, 1, 8, 7, 9};
		Integer[] aIn = {1, 3, 6, 7, 8, 9};
		
		Set<Integer> pre = new HashSet<Integer>(Arrays.asList(aPre));
		Set<Integer> in = new HashSet<Integer>(Arrays.asList(aIn));
		
		for(int i : pre)
			System.out.println(i);

		for(int i : in)
			System.out.println(i);
		
		System.out.println(arrEquals(new SubArr(aPre, 0, aPre.length - 1), new SubArr(aIn, 0, aIn.length - 1)));
		
		System.out.println(assemble(new SubArr(aPre, 0, aPre.length - 1), new SubArr(aIn, 0, aIn.length - 1)));
	}
	
	private static String assemble(SubArr aPre, SubArr aIn) {
		if(!arrEquals(aPre, aIn))
			return "ERROR!";
		
		Integer nextNode = aPre.arr[aPre.first];
		int nodePosIn = getPositionOf(nextNode, aIn);
		
		SubArr nextLeftIn = new SubArr(aIn.arr, aIn.first, nodePosIn - 1);
		SubArr nextRightIn = new SubArr(aIn.arr, nodePosIn + 1, aIn.last);
		
		SubArr nextLeftPre = new SubArr(aPre.arr, aPre.first + 1, aPre.first + 1 + (nextLeftIn.last - nextLeftIn.first));
		SubArr nextRightPre = new SubArr(aPre.arr, aPre.first + 2 + (nextLeftIn.last - nextLeftIn.first), aPre.last);
		
		String res = "(";
		
		if(validateSubArr(nextLeftPre)) // => nextLeftIn correct?
			res += assemble(nextLeftPre, nextLeftIn);
		else
			res += "n";
		
		res += "," + nextNode + ",";
		
		if(validateSubArr(nextRightPre)) // => nextRightIn correct?
			res += assemble(nextRightPre, nextRightIn);
		else
			res += "n";
		
		res += ")";
		
		return res;
	}
	
	private static boolean validateSubArr(SubArr a) {
		if(a.last - a.first < 0)
			return false;
		
		if(a.first < 0 || a.first >= a.arr.length)
			return false;
		
		if(a.last < 0 || a.last >= a.arr.length)
			return false;
		
		return true;
	}
	
	private static int getPositionOf(Integer node, SubArr a) {
		for(int i = a.first; i <= a.last; i++)
			if(a.arr[i].equals(node))
				return i;
		
		return -1;
	}
	
	private static boolean arrEquals(SubArr a1, SubArr a2) {
		if(a1.last - a1.first != a2.last - a2.first)
			return false;
		
		for(int i = a1.first; i <= a1.last; i++) {
			Integer cur1 = a1.arr[i];
			boolean found = false;
			for(int j = a2.first; j <= a2.last; j++) {
				if(cur1.equals(a2.arr[j])) {
					found = true;
					break;
				}
			}
			if(!found)
				return false;
		}
		
		return true;
	}
}

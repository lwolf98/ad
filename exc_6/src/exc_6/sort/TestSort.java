package exc_6.sort;

import java.util.Arrays;

import exc_6.sort.algorithms.CountSort;
import exc_6.sort.algorithms.CountSort2k3n;
import exc_6.sort.algorithms.CountSort5k3n;
import exc_6.sort.algorithms.CountSortIdea;
import exc_6.sort.algorithms.MapSort;

public class TestSort {
	public static void main(String[] args) {
		int[] a_base = {1, 2, 3, 1, 2, 3, 3, 2, 3, 2, 3, 2, 1, 2, 3, 3, 1, 2, 3, 1, 2, 1, 2, 1, 2, 2, 3, 1, 2, 1, 2, 3};
		//a = new int[] {3, 1};
		int[] a = a_base.clone();
		new CountSort(3).sort(a);
		System.out.println(Arrays.toString(a));

		a = a_base.clone();
		new CountSort5k3n(3).sort(a);
		System.out.println(Arrays.toString(a));

		a = a_base.clone();
		a = new CountSort2k3n(3).sort(a);
		System.out.println(Arrays.toString(a));

		a = a_base.clone();
		new CountSortIdea(3).sort(a);
		System.out.println(Arrays.toString(a));

		a = a_base.clone();
		new MapSort(1.25).sort(a);
		System.out.println(Arrays.toString(a));

		a = new int[] {3, 1, 56, 5, 64, 185, 4154, 6, 1};
		//a = new int[] {34, 45, 12, 34, 23, 18, 38, 17, 43, 7};
		new MapSort(1.5).sort(a);
		System.out.println(Arrays.toString(a));
	}
}

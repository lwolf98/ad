package exc_10.search;

public class TestSearch {
	public static void main(String[] args) {
		String text = "ALGORITHMEN UND DATENSTRUKTUREN";
		String muster = "DATEN";

		System.out.println("Found: " + NaiveSearch.naiveSearch(text.toCharArray(), muster.toCharArray()));
		System.out.println("Found: " + NaiveSearch.naiveSearchLinear(text.toCharArray(), muster.toCharArray()));
	}
}

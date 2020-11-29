package exc_7.searchtree;

public class TestOrder {
	public static void main(String[] args) {
		SearchTreeMasterDeleter<Integer> tree = new SearchTreeMasterDeleter<Integer>();
		tree.insert(6);
		tree.insert(3);
		tree.insert(8);
		tree.insert(1);
		tree.insert(7);
		tree.insert(9);
		
		tree.printPre();
		tree.print();
		tree.printPost();
		
		SearchTreeMasterDeleter<Integer> treeReplica = new SearchTreeMasterDeleter<Integer>(new Integer[] {6, 3, 1, 8, 7, 9});
		treeReplica.print();
	}
}

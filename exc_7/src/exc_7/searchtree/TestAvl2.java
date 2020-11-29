package exc_7.searchtree;

public class TestAvl2 {
	public static void main(String[] args) {
		AvlTree<Integer> tree = new AvlTree<Integer>();
		tree.insert(5);
		tree.insert(6);
		tree.insert(9);
		tree.insert(12);
		tree.insert(13);
		tree.insert(3);
		tree.insert(8);
		tree.insert(10);
		tree.insert(11);
		tree.insert(16);
		tree.insert(15);
		tree.insert(14);
		tree.insert(4);
		tree.insert(2);
		tree.insert(1);
		
		tree.print();
		
		tree.deleteValue(12);
		tree.print();
		tree.deleteValue(8);
		tree.print();
		tree.deleteValue(5);
		tree.print();
		tree.deleteValue(4);
		tree.print();
		tree.deleteValue(3);
		tree.print();
		tree.deleteValue(6);
		tree.print();
		tree.deleteValue(15);
		tree.print();
		tree.deleteValue(14);
		
		tree.print();
	}
}

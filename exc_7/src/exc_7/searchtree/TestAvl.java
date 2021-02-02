package exc_7.searchtree;

public class TestAvl {
	public static void main(String[] args) {
		AvlTree<Integer> tree = new AvlTree<Integer>();
		tree.insert(6);
		tree.insert(3);
		tree.insert(8);
		tree.insert(1);
		tree.insert(7);
		tree.insert(9);
		tree.insert(45);
		tree.insert(23);
		tree.insert(57);
		tree.insert(12);
		tree.insert(30);
		tree.insert(25);
		tree.insert(33);
		
		System.out.println(tree.contains(7));
		System.out.println(tree.contains(10));
		
		tree.print();
		
		tree.deleteValue(6);
		tree.print();
		tree.deleteValue(3);
		tree.print();
		tree.deleteValue(9);
		tree.print();
		tree.deleteValue(1);
		tree.print();
		tree.deleteValue(7);
		tree.print();
		tree.deleteValue(8);
		tree.print();
		tree.deleteValue(23);
		tree.print();
		tree.deleteValue(25);
		tree.print();
		tree.deleteValue(45);
		tree.print();
		tree.deleteValue(99);
		tree.print();
		tree.deleteValue(12);
		tree.print();
		tree.deleteValue(30);
		tree.print();
		tree.deleteValue(33);
		tree.print();
		tree.deleteValue(57);
		tree.print();
		tree.deleteValue(57);
		tree.print();
		
		
		System.out.println("Example VL:");
		tree.insert(18);
		tree.insert(12);
		tree.insert(27);
		tree.insert(7);
		tree.insert(15);
		tree.insert(23);
		tree.insert(34);
		
		tree.print();
		
		tree.deleteValue(7);
		tree.print();
		tree.deleteValue(12);
		tree.print();
		tree.deleteValue(15);
		tree.print();
		tree.deleteValue(18);
		tree.print();
		tree.deleteValue(23);
		tree.print();
		tree.deleteValue(27);
		tree.print();
		tree.deleteValue(34);
		tree.print();
	}
}

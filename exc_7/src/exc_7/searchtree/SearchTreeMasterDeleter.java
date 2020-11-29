package exc_7.searchtree;

public class SearchTreeMasterDeleter <T extends Comparable<T>> {
	protected TreeElement root;
	
	protected enum Direction {
		Left,
		Right
	}
	
	protected Direction invertDir(Direction dir) {
		return dir == Direction.Left ? Direction.Right : Direction.Left;
	}
	
	protected class TreeElement {
		public T value;
		public TreeElement left;
		public TreeElement right;
		
		public TreeElement(T value) {
			this.value = value;
		}
		
		public TreeElement getNext(Direction dir) {
			if(dir == Direction.Left)
				return left;
			else
				return right;
		}
		
		public void setNext(Direction dir, TreeElement elem) {
			if(dir == Direction.Left)
				left = elem;
			else
				right = elem;
		}
	}
	
	protected class StepLog {
		public TreeElement cur;
		public TreeElement prev;
		public Direction dir;
		
		public StepLog(TreeElement cur, TreeElement prev, Direction dir) {
			this.cur = cur;
			this.prev = prev;
			this.dir = dir;
		}
	}
	
	protected class ElemProcessed {
		public void perform(TreeElement elem, Direction dir) {
		}
	}
	
	public SearchTreeMasterDeleter() {
		//...
	}
	
	protected void insert(TreeElement curRoot, TreeElement elem, ElemProcessed p) {
		if(elem.value.compareTo(curRoot.value) <= 0) {
			if(curRoot.left == null)
				curRoot.left = elem;
			else
				insert(curRoot.left, elem, p);

			p.perform(curRoot, Direction.Left);
		} else {
			if(curRoot.right == null)
				curRoot.right = elem;
			else
				insert(curRoot.right, elem, p);
			
			p.perform(curRoot, Direction.Right);
		}
	}
	
	private void print(TreeElement root) {
		if(root != null) {
			System.out.print("(");
			print(root.left);
			System.out.print("," + root.value + ",");
			print(root.right);
			System.out.print(")");
		} else {
			System.out.print("n");
		}
	}
	
	private StepLog getElement(T value) {
		TreeElement cur = root;
		TreeElement prev = null;
		Direction dir = null;
		
		while(cur != null) {
			int res = value.compareTo(cur.value);
			if(res < 0) {
				prev = cur;
				cur = cur.left;
				dir = Direction.Left;
			} else if(res > 0) {
				prev = cur;
				cur = cur.right;
				dir = Direction.Right;
			} else
				return new StepLog(cur, prev, dir);

		}
		
		return null;
	}
	
	private StepLog getLast(TreeElement localRoot, Direction dir, TreeElement localRootPrev) {
		TreeElement cur = localRoot;
		TreeElement prev = localRootPrev;
		
		//TODO: Prüfung cur auf null?
		
		while(cur.getNext(dir) != null) {
			prev = cur;
			cur = cur.getNext(dir);
		}
		
		//Wenn schleife nicht ausgeführt wurde
		if(localRoot == cur) {
			if(dir == Direction.Left)
				dir = Direction.Right;
			else
				dir = Direction.Left;
		}
		
		StepLog log = new StepLog(cur, prev, dir);
		return log;
	}
	
	public void insert(T value) {
		TreeElement elem = new TreeElement(value);
		
		if(root == null)
			root = elem;
		else
			insert(root, elem, new ElemProcessed());
	}
	
	public boolean contains(T value) {
		TreeElement cur = root;

		while(cur != null) {
			int res = value.compareTo(cur.value);
			if(res < 0)
				cur = cur.left;
			else if(res > 0)
				cur = cur.right;
			else
				return true;
		}
		
		return false;
	}
	
	private boolean deleteValue(StepLog log) {
		TreeElement prev = log.prev;
		TreeElement cur = log.cur;
		
		//1. Fall: kein Nachfolger
		if(cur.left == null && cur.right == null) {
			if(prev != null)
				prev.setNext(log.dir, null);
			else
				root = null;
			
			return true;
		}
		
		//2. Fall: ein Nachfolger
		if(cur.left == null) {
			if(prev != null)
				prev.setNext(log.dir, cur.right);
			else
				root = cur.right;
			
			return true;
		} else if(cur.right == null) {
			if(prev != null)
				prev.setNext(log.dir, cur.left);
			else
				root = cur.left;
			
			return true;
		}
		
		return false;
	}
	
	public void deleteValue(T value) {
		//Wert finden
		StepLog log = getElement(value);
		
		//Verlassen, wenn der Wert nicht gefunden wurde
		if(log == null)
			return;
		
		if(deleteValue(log))
			return;
		
		TreeElement cur = log.cur;
		
		//3. Fall (regulär): zwei Nachfolger
		
		StepLog smallestRightLog = getLast(cur.right, Direction.Left, cur);
		swap(cur, smallestRightLog.cur);
		deleteValue(smallestRightLog);
	}
	
	private void swap(TreeElement elem1, TreeElement elem2) {
		T tmp = elem1.value;
		elem1.value = elem2.value;
		elem2.value = tmp;
	}

	public void print() {
		print(root);
		System.out.println();
	}
	
	public String printPre() {
		String s = printPre(root);
		System.out.println(s);
		return s;
	}
	
	public void printPost() {
		printPost(root);
		System.out.println();
	}
	
	private String printPre(TreeElement root) {
		String s = "";
		if(root != null) {
			s += "(" + root.value + ",";
			s += printPre(root.left) + ",";
			s += printPre(root.right) + ")";
		} else {
			s += "n";
		}
		
		return s;
	}
	
	private void printPost(TreeElement root) {
		if(root != null) {
			System.out.print("(");
			printPost(root.left); System.out.print(",");
			printPost(root.right);
			System.out.print("," + root.value + ")");
		} else {
			System.out.print("n");
		}
	}
	
	public SearchTreeMasterDeleter(T[] arr) {
		for(T e : arr)
			insert(e);
	}
}

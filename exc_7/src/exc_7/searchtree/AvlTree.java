package exc_7.searchtree;

public class AvlTree<T extends Comparable<T>> extends SearchTreeMasterDeleter<T> {
	protected class AvlTreeElement extends TreeElement {
		public int height;
		
		public AvlTreeElement(T value) {
			super(value);
			height = 0;
		}
		
		@SuppressWarnings("unchecked")
		public AvlTreeElement getRight() {
			return (AvlTreeElement) right;
		}
		
		@SuppressWarnings("unchecked")
		public AvlTreeElement getLeft() {
			return (AvlTreeElement) left;
		}
	}
	
	@Override
	public void deleteValue(T value) {
		super.deleteValue(value);
		
		correctTree(new StepLog(root, null, null), value);
	}
	
	@Override
	public void insert(T value) {
		AvlTreeElement elem = new AvlTreeElement(value);
		
		if(root == null)
			root = elem;
		else {
			insert(root, elem, new ElemProcessed() {
				/*@SuppressWarnings("unchecked")
				@Override
				public void perform(TreeElement elem, Direction dir) {
					checkRotation((AvlTreeElement) elem, dir);
				}*/
			});
			
			System.out.println("Before rotation:");
			print();
			/*Stack<StepLog> path = getPathTo(value);
			while(!path.isEmpty()) {
				StepLog log = path.pop();
				checkRotation((AvlTreeElement) log.prev, invertDir(log.dir));
			}*/
			
			correctTree(new StepLog(root, null, null), value);
			
			System.out.println("After rotation:");
			print();
		}
	}
	
	@SuppressWarnings("unchecked")
	private void correctTree(StepLog elemLog, T value) {
		if(elemLog == null)
			return;
		
		if(elemLog.cur == null)
			return;
		
		if(value.compareTo(elemLog.cur.value) <= 0) {
			correctTree(new StepLog((elemLog.cur).left, elemLog.cur, Direction.Left), value);
			if(elemLog.prev != null)
				elemLog.prev.setNext(elemLog.dir, checkRotationRight((AvlTree<T>.AvlTreeElement) elemLog.cur));
			else
				root = checkRotationRight((AvlTreeElement) elemLog.cur); //root.setNext(Direction.Left, checkRotationRight((AvlTreeElement) elemLog.cur));
		} else {
			correctTree(new StepLog(elemLog.cur.right, elemLog.cur, Direction.Right), value);
			if(elemLog.prev != null)
				elemLog.prev.setNext(elemLog.dir, checkRotationLeft((AvlTreeElement) elemLog.cur));
			else
				root = checkRotationLeft((AvlTreeElement) elemLog.cur); //root.setNext(Direction.Right, checkRotationLeft((AvlTreeElement) elemLog.cur));
		}
		
	}
	
	private int max(int a, int b) {
		return a < b ? b : a;
	}
	
	private int getHeight(AvlTreeElement elem) {
		if(elem == null)
			return -1;
		
		return elem.height;
	}
	
	private void updateHeight(AvlTreeElement elem) {
		elem.height = 1 + max(getHeight(elem.getLeft()), getHeight(elem.getRight()));
	}
	
	private AvlTreeElement rotateLeft(AvlTreeElement a) {
		AvlTreeElement b = a.getRight();
		a.right = b.left;
		b.left = a;
		a = b; //!
		
		updateHeight(a.getLeft());
		updateHeight(a); //!
		
		return a;
	}
	
	private AvlTreeElement rotateRight(AvlTreeElement a) {
		AvlTreeElement b = a.getLeft();
		a.left = b.right;
		b.right = a;
		a = b; //!
		
		updateHeight(a.getRight());
		updateHeight(a); //!
		
		return a;
	}
	
	private AvlTreeElement doubleRotationLeft(AvlTreeElement a) {
		a.right = rotateRight(a.getRight());
		a = rotateLeft(a);
		
		return a;
	}
	
	private AvlTreeElement doubleRotationRight(AvlTreeElement a) {
		a.left = rotateLeft(a.getLeft());
		a = rotateRight(a);
		
		return a;
	}
	
	private AvlTreeElement checkRotationLeft(AvlTreeElement elem) {
		if(elem == null)
			return null;
		
		if(elem.right != null) {
			if(getHeight(elem.getRight()) - getHeight(elem.getLeft()) == 2) {
				if(getHeight(elem.getRight().getLeft()) > getHeight(elem.getRight().getRight()))
					elem = doubleRotationLeft(elem);
				else
					elem = rotateLeft(elem);
				
			} else updateHeight(elem);
		} else updateHeight(elem);
		
		return elem;
	}
	
	private AvlTreeElement checkRotationRight(AvlTreeElement elem) {
		if(elem == null)
			return null;
		
		if(elem.left != null) {
			if(getHeight(elem.getLeft()) - getHeight(elem.getRight()) == 2) {
				if(getHeight(elem.getLeft().getRight()) > getHeight(elem.getLeft().getLeft()))
					elem = doubleRotationRight(elem);
				else
					elem = rotateRight(elem);
				
			} else updateHeight(elem);
		} else updateHeight(elem);
		
		return elem;
	}
	
	/*private AvlTreeElement checkRotation(AvlTreeElement elem, Direction dir) {
		if(dir == Direction.Left)
			elem = checkRotationLeft(elem);
		else
			elem = checkRotationRight(elem);
		
		return elem;
	}
	
	private Stack<StepLog> getPathTo(T value) {
		Stack<StepLog> path = new Stack<StepLog>();
		
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
				break;

			path.push(new StepLog(cur, prev, dir));
		}
		
		return path;
	}*/
}

package exc_11.list;

public class PriorityQueueGeneric<T> {
	private QueueEntry<T>[] list;
	private int curLast;
	
	@SuppressWarnings("unchecked")
	public PriorityQueueGeneric(int len) {
		list = new QueueEntry[len];
		curLast = -1;
	}
	
	public void print() {
		for(int i = 0; i <= curLast; i++) {
			for(int j = 0; j < Math.pow(2, i) && Math.pow(2, i) <= curLast; j++)
				if(list[j + (int)Math.pow(2, i) - 1] != null)
					System.out.print(list[j + (int)Math.pow(2, i) - 1].key + " ");
		
			System.out.println();
		}
	
	}
	
	public void insert(T elem, int key) {
		if(curLast >= list.length - 1)
			return;
		
		QueueEntry<T> e = new QueueEntry<T>(elem);
		list[++curLast] = e;
		
		decreaseKey(curLast, key);
	}
	
	public T getMin() {
		return (T) list[0].elem;
	}
	
	public T extractMin() {
		swap(0, curLast);
		QueueEntry<T> min = list[curLast];
		list[curLast] = null;
		curLast--;
		
		heapify(0);
		
		return (T) min.elem;
	}
	
	public void decreaseKey(T elem, int key) {
		//...
	}
	
	private void decreaseKey(int pos, int key) {
		QueueEntry<T> cur = list[pos];
		if(cur.key <= key)
			return;
		
		cur.key = key;
		
		while (pos > 0) {
			int pos_parent = (pos - 1) / 2;
			if(list[pos_parent].key > cur.key)
				swap(pos, pos_parent);
			
			pos = pos_parent;
		}
	}
	
	public void buildHeap() {
		int n = curLast + 1;
		for(int i = (n - 2) / 2; i >= 0; i--)
			heapify(i);
	}
	
	private void heapify(int root) {
		int smallest;
		int left = root * 2 + 1;
		int right = root * 2 + 2;
		if(left <= curLast && list[left].key < list[root].key)
			smallest = left;
		else
			smallest = root;
		
		if(right <= curLast && list[right].key < list[smallest].key)
			smallest = right;
		
		if(smallest != root) {
			swap(root, smallest);
			heapify(smallest);
		}
	}
	
	private void swap(int pos1, int pos2) {
		QueueEntry<T> tmp = list[pos1];
		list[pos1] = list[pos2];
		list[pos2] = tmp;
	}
}

class QueueEntry<T> {
	int key;
	T elem;
	
	public QueueEntry(T elem) {
		key = Integer.MAX_VALUE;
		this.elem = elem;
	}
}

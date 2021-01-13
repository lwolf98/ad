package exc_11.list;

/*
 * Platzkomplexität: ~ n * (1 + 2) (Arrayeintrag + 2 Felder von QueueEntry) => O(n)
 */
public class PriorityQueue<T> {
	private QueueEntry<T>[] list;
	private int curLast;
	
	@SuppressWarnings("unchecked")
	public PriorityQueue(int len) {
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
	
	/*
	 * Laufzeit: O(log n)
	 */
	public void insert(T elem, int key) {
		if(curLast >= list.length - 1)
			return;
		
		QueueEntry<T> e = new QueueEntry<T>(elem);
		list[++curLast] = e;
		
		decreaseKey(curLast, key);
	}
	
	/*
	 * Laufzeit: O(1)
	 */
	public T getMin() {
		return (T) list[0].elem;
	}
	
	/*
	 * Lauzeit: O(log n)
	 */
	public T extractMin() {
		swap(0, curLast);
		QueueEntry<T> min = list[curLast];
		list[curLast] = null;
		curLast--;
		
		heapify(0);
		
		return (T) min.elem;
	}
	
	/*
	 * Laufzeit: O(n) ...
	 * => Mapping elem -> pos
	 */
	public void decreaseKey(T elem, int key) {
		decreaseKey(indexOf(elem), key);
	}
	
	/*
	 * Laufzeit: O(log n)
	 */
	private void decreaseKey(int pos, int key) {
		QueueEntry<T> cur = list[pos];
		if(cur.key <= key)
			return;
		
		cur.key = key;
		
		while(pos > 0) {
			int pos_parent = (pos - 1) / 2;
			if(list[pos_parent].key > cur.key)
				swap(pos, pos_parent);
			else
				break; //break to reduce loops, condition should be included inside while(...)
			
			pos = pos_parent;
		}
	}
	
	/*
	 * Laufzeit: O(n) ...
	 */
	private int indexOf(T elem) {
		for(int i = 0; i < list.length; i++)
			if(elem.equals(list[i].elem))
				return i;
		
		return -1;
	}
	
	/*
	 * Laufzeit: O(log n)
	 */
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
	
	/*
	 * Laufzeit: O(1)
	 */
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

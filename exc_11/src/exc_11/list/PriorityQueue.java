package exc_11.list;

public class PriorityQueue {
	private class QueueEntry {
		int key;
		Object elem;
		
		public QueueEntry(int key, Object elem) {
			this.key = key;
			this.elem = elem;
		}
	}
	
	private QueueEntry[] list;
	private int curLast;
	
	public PriorityQueue(int len) {
		list = new QueueEntry[len];
		curLast = 0;
	}
	
	public void print() {
		for(int i = 0; i <= curLast; i++)
			for(int j = 0; j < Math.pow(2, i) && Math.pow(2, i) < curLast + 1; j++)
				System.out.println(list[j + (int)Math.pow(2, i) - 1].key + " ");
	
	}
	
	public void insert(Object elem, int key) {
		insert(elem, key, true);
	}
	
	public void insert(Object elem, int key, boolean heapify) {
		if(curLast >= list.length - 1)
			return;
		
		QueueEntry e = new QueueEntry(key, elem);
		list[++curLast] = e;
		
		if(heapify)
			heapify(0);
	}
	
	public Object getMin() {
		return list[0].elem;
	}
	
	public Object extractMin() {
		swap(0, curLast);
		QueueEntry min = list[curLast];
		list[curLast] = null;
		curLast--;
		
		heapify(0);
		
		return min.elem;
	}
	
	public void decreaseKey(Object elem, int pos, int key) {
		QueueEntry cur = list[pos];
		if(cur.key <= key)
			return;
		
		cur.key = key;
		heapify(0); //heapify von 0 aus nötig?
	}
	
	public void buildHeap(Object[] elements) {
		for(Object elem : elements)
			insert(elem, Integer.MAX_VALUE, false);
		
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
		QueueEntry tmp = list[pos1];
		list[pos1] = list[pos2];
		list[pos2] = tmp;
	}
}

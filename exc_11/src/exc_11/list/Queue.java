package exc_11.list;

public class Queue<T> {
	private T[] list;
	private int beforeFirst;
	private int last;
	private int size;
	
	@SuppressWarnings("unchecked")
	public Queue(int len) {
		list = (T[]) new Object[len];
		beforeFirst = 0;
		last = 0;
		size = 0;
	}
	
	public void enqueue(T elem) {
		if(size == list.length)
			return;
		
		last = (last + 1) % list.length;
		list[last] = elem;
		
		size++;
	}
	
	public T dequeue() {
		if(size == 0)
			return null;
		
		beforeFirst = (beforeFirst + 1) % list.length;
		size--;
		return list[beforeFirst];
	}
	
	public int size() {
		return size;
	}
}

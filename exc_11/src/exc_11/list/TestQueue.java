package exc_11.list;

public class TestQueue {
	public static void main(String[] args) {
		Queue<Integer> q = new Queue<Integer>(3);
		q.enqueue(12);
		q.enqueue(23);
		q.dequeue();
		q.enqueue(12);
		q.enqueue(23);
		q.dequeue();
		q.dequeue();
		
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}
}

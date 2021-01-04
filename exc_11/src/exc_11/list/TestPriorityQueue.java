package exc_11.list;

public class TestPriorityQueue {
	public static void main(String[] args) {
		//PriorityQueue q = new PriorityQueue(10);
		PriorityQueueGeneric<Integer> q = new PriorityQueueGeneric<Integer>(10);
		q.insert(1, 10);
		q.insert(2, 3);
		q.insert(4, 15);
		q.insert(5, 14);
		q.insert(6, 1);
		q.insert(7, 12);
		
		q.print();
	}
}

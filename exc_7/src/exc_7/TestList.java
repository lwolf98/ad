package exc_7;

public class TestList {
	public static void main(String[] args) {
		Container head = new Container(2);
		head.next = new Container(3);
		head.next.prev = head;
		
		Container curr = head.next;
		curr = null;
		
		System.out.println("Tatsächliche Referenz gelöscht?: " + (head.next == null));
		System.out.println("Value: " + head.next.value);
		
		curr = head.next;
		curr.prev.next = null;

		System.out.println("Tatsächliche Referenz gelöscht?: " + (head.next == null));
		System.out.println("Value: " + head.next.value);
		
	}
}

class Container {
	Container next;
	Container prev;
	int value;
	
	public Container(int value) {
		this.value = value;
	}
}

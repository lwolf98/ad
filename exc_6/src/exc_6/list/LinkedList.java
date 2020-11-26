package exc_6.list;

import java.util.Iterator;

public class LinkedList <T extends Comparable<T>> implements Iterable<T> {
	private QuickSortLinkedList<T> qSort;
	private ListEntry<T> head;
	private ListEntry<T> tail;
	private int size;
	
	public LinkedList() {
		qSort = new QuickSortLinkedList<T>();
		head = null;
		tail = null;
		size = 0;
	}
	
	public void append(T item) {
		ListEntry<T> newEntry = new ListEntry<T>(item);
		if(head == null)
			head = newEntry;
		else
			tail.next = newEntry;
		
		tail = newEntry;
		size++;
	}
	
	public void deleteList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public void deleteValue(T item) {
		ListEntry<T> cur = head;
		ListEntry<T> prev = null;
		
		while(cur != null) {
			if(cur.value == item) {
				if(prev == null)
					head = cur.next;
				else
					prev.next = cur.next;
				
				if(cur == tail)
					tail = prev;
				
				size--;
			} else {
				prev = cur;
			}
			
			cur = cur.next;
		}
	}
	
	public T getValueAt(int index) {
		return getEntryAt(index).value;
	}
	

	/**
	 * Hier ist bewusst kein Zugriffsmodifizierer vergeben, damit die Methode nur im
	 * aktuellen Package zugreifbar ist.
	 */
	ListEntry<T> getEntryAt(int index) {
		if(index >= size || index < 0)
			return null;
		
		ListEntry<T> cur = head;
		for(int i = 0; i < index; i++)
			cur = cur.next;
		
		return cur;
	}
	
	public int size() {
		return size;
	}
	
	public void quickSort() {
		qSort.sort(this);
	}
	
	public void print() {
		ListEntry<T> cur = head;
		while(cur != null) {
			System.out.print(cur + " ");
			cur = cur.next;
		}

		System.out.println();
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private ListEntry<T> cur = head;
			
			@Override
			public boolean hasNext() {
				if(cur == null)
					return false;
				
				return cur != null;
			}

			@Override
			public T next() {
				T val = cur.value;
				cur = cur.next;
				return val;
			}
		};
	}
}

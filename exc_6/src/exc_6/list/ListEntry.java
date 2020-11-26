package exc_6.list;

public class ListEntry <T> {
	public T value;
	public ListEntry<T> next;
	
	public ListEntry(T value) {
		this.value = value;
		next = null;
	}
	
	@Override
	public String toString() {
		return value.toString();
	}
}

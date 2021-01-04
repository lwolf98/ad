package exc_11.search;

public class Node {
	public enum Color {
		White,
		Grey,
		Black
	}
	
	public enum Type {
		BFS,
		DFS
	}
	
	public int value;
	public Type type = null;
	public Color color = Color.White;
	
	public int dist = Integer.MAX_VALUE;
	public int firstTime = 0;
	public int lastTime = 0;
	public Node pred = null;
	
	public Node(int value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		switch (type) {
			case BFS: return "V: " + value + " (C: " + color + ", D: " + dist + ", P: [" + pred + "])";
			case DFS: return "V: " + value + " (C: " + color + ", FT: " + firstTime + ", LT: " + lastTime + ", P: [" + pred + "])";
		}
		
		return null;
	}
}

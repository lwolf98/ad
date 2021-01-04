package exc_11.search;

import java.util.HashMap;

public class Graph extends HashMap<Node, Node[]> {
	private static final long serialVersionUID = 1L;
	
	@Override
	public Node[] put(Node keyNode, Node[] edges) {
		
		return super.put(keyNode, edges);
	}
}

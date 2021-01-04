package exc_11.search;

import java.util.HashMap;
import java.util.Map;

public class TestSearchA1 {
	public static void main(String[] args) {
		Node v0 = new Node(0);
		Node v1 = new Node(1);
		Node v2 = new Node(2);
		Node v3 = new Node(3);
		Node v4 = new Node(4);
		Node v5 = new Node(5);
		Node v6 = new Node(6);
		Node v7 = new Node(7);
		Node v8 = new Node(8);
		
		Map<Node, Node[]> graph = new HashMap<Node, Node[]>();
		
		graph.put(v0, new Node[] {v1, v2, v6});
		graph.put(v1, new Node[] {v3});
		graph.put(v2, new Node[] {v0, v3, v4});
		graph.put(v3, new Node[] {v6});
		graph.put(v4, new Node[] {v0, v5, v8});
		graph.put(v5, new Node[] {v2, v3, v4, v7});
		graph.put(v6, new Node[] {v7});
		graph.put(v7, new Node[] {v3, v8});
		graph.put(v8, new Node[] {v5});
		
		System.out.println("BFS:");
		BFS.search(graph, v0);
		
		System.out.println("\nDFS:");
		DFS.searchTMP(graph, v0);
	}
}

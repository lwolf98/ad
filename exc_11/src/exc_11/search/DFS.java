package exc_11.search;

import java.util.Map;

import exc_11.search.Node.Color;
import exc_11.search.Node.Type;

/**
 * 
 * Tiefensuche
 *
 */
public class DFS {
	private static int time;
	
	public static void search(Map<Node, Node[]> graph) {
		for(Node u : graph.keySet()) {
			u.type = Type.DFS;
			u.color = Color.White;
			u.pred = null;
		}
		
		time = 0;
		for(Node u : graph.keySet())
			if(u.color == Color.White)
				search(graph, u);
	}
	
	public static void searchTMP(Map<Node, Node[]> graph, Node u) {
		for(Node v : graph.keySet()) {
			v.type = Type.DFS;
			v.color = Color.White;
			v.pred = null;
		}
		
		time = 0;
		search(graph, u);
	}
	
	private static void search(Map<Node, Node[]> graph, Node u) {
		time++;
		u.firstTime = time;
		u.color = Color.Grey;
		
		System.out.println("Loop node " + u.value + ":");
		for(Node v : graph.get(u)) {
			if(v.color == Color.White) {
				v.pred = u;
				search(graph, v);
			}
			System.out.println(v);
		}
		
		u.color = Color.Black;
		time++;
		u.lastTime = time;
		System.out.println(u);
	}
}

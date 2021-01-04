package exc_11.search;

import java.util.Map;

import exc_11.list.Queue;
import exc_11.search.Node.Color;
import exc_11.search.Node.Type;

/**
 * 
 * Breitensuche
 *
 */
public class BFS {
	public static void search(Map<Node, Node[]> graph, Node v0) {
		for(Node u : graph.keySet()) {
			u.type = Type.BFS;
			u.color = Color.White;
			u.dist = Integer.MAX_VALUE;
			u.pred = null;
		}
		
		v0.color = Color.Grey;
		v0.dist = 0;
		v0.pred = null;
		
		Queue<Node> q = new Queue<Node>(graph.size());
		q.enqueue(v0);
		
		while(q.size() > 0) {
			Node u = q.dequeue();
			System.out.println("Loop node " + u.value + ":");
			for(Node v : graph.get(u)) {
				if(v.color == Color.White) {
					v.color = Color.Grey;
					v.dist = u.dist + 1;
					v.pred = u;
					q.enqueue(v);
				}
				System.out.println(v);
			}
			u.color = Color.Black;
		}
	}
}

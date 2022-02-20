package am;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph133 {

	class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
			val = 0;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}

	Map<Node, Node> map = new HashMap<Node, Node>();

	public Node cloneGraph(Node node) {
		if (node == null) {
			return null;
		}

		if (map.containsKey(node)) {
			return map.get(node);
		}

		Node cloneNode = new Node(node.val, new ArrayList<Node>());
		map.put(node, cloneNode);

		for (Node neighbor : node.neighbors) {
			cloneNode.neighbors.add(cloneGraph(neighbor));
		}

		return cloneNode;
	}
}

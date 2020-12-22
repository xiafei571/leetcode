package algo.expert;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {
	// Do not edit the class below except
	// for the breadthFirstSearch method.
	// Feel free to add new properties
	// and methods to the class.
	static class Node {
		String name;
		List<Node> children = new ArrayList<Node>();

		public Node(String name) {
			this.name = name;
		}

		public List<String> breadthFirstSearch(List<String> array) {
			// Write your code here.
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(this);
			while (!queue.isEmpty()) {
				Node current = queue.poll();
				array.add(current.name);
				if (current.children != null) {
					for (Node node : current.children) {
						queue.add(node);
					}
				}
			}
			return array;
		}

		public Node addChild(String name) {
			Node child = new Node(name);
			children.add(child);
			return this;
		}
	}
}

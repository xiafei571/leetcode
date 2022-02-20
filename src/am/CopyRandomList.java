package am;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {
	class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	public Node copyRandomList(Node head) {
		if (head == null) {
			return null;
		}

		Map<Node, Node> map = new HashMap<Node, Node>();
		Node curr = head;
		while (curr != null) {
			map.put(curr, new Node(curr.val));
			curr = curr.next;
		}

		Node copy = map.get(head);
		curr = head;
		while (curr != null) {
			copy.next = map.getOrDefault(curr.next, null);
			copy.random = map.getOrDefault(curr.random, null);
			copy = copy.next;
			curr = curr.next;
		}

		return map.get(head);
	}
}

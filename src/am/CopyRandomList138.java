package am;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList138 {

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

	//old -> new
	Map<Node, Node> map = new HashMap<Node, Node>();
	public Node copyRandomList(Node head) {
		if(head == null) {
			return null;
		}
		
		if(map.containsKey(head)) {
			return map.get(head);
		}
		
		Node newNode = new Node(head.val);
		map.put(head, newNode);
		newNode.next = copyRandomList(head.next);
		newNode.random = copyRandomList(head.random);
		
		return newNode;
	}
}

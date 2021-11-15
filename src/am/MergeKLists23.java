package am;

import java.util.PriorityQueue;

public class MergeKLists23 {
	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);
		for (ListNode node : lists) {
			if (node != null)
				heap.offer(node);
		}

		ListNode curr = new ListNode();
		ListNode head = curr;

		while (heap.size() > 0) {
			ListNode peekNode = heap.poll();
			curr.next = new ListNode(peekNode.val);
			curr = curr.next;

			peekNode = peekNode.next;
			if (peekNode != null) {
				heap.offer(peekNode);
			}
		}

		return head.next;

	}
}

package leetcode;

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
		if (lists == null || lists.length == 0) {
			return null;
		}

		PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

		for (ListNode listNode : lists) {
			if (listNode != null)
				minHeap.add(listNode);
		}

		ListNode head = new ListNode(-1);
		ListNode cur = head;
		while (!minHeap.isEmpty()) {
			ListNode node = minHeap.poll();
			cur.next = node;
			cur = cur.next;
			if (node.next != null) {
				minHeap.add(node.next);
			}
		}

		return head.next;

	}
}

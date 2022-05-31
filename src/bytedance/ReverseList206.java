package bytedance;

import common.ListNode;

public class ReverseList206 {
	public ListNode reverseList(ListNode head) {
		ListNode last = null;
		ListNode curr = head;
		ListNode next;

		while (curr != null) {
			next = curr.next;
			curr.next = last;
			last = curr;
			curr = next;
		}

		return last;
	}
}

package am;

public class AddTwoNumbers2 {
	/**
	 * Definition for singly-linked list.
	 */
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

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int rest = 0;
		ListNode head = new ListNode();
		ListNode curr = head;

		while (l1 != null || l2 != null) {
			int temp = 0;
			if (l1 != null && l2 != null) {
				temp = l1.val + l2.val + rest;
				l1 = l1.next;
				l2 = l2.next;
			} else if (l1 != null) {
				temp = l1.val + rest;
				l1 = l1.next;
			} else {
				temp = l2.val + rest;
				l2 = l2.next;
			}

			if (temp >= 10) {
				temp = temp % 10;
				rest = 1;
			} else {
				rest = 0;
			}

			curr.next = new ListNode(temp);
			curr = curr.next;
		}

		if (rest > 0) {
			curr.next = new ListNode(rest);
		}

		return head.next;
	}
}

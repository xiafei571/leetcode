package am;

import java.util.Stack;

public class AddTwoNumbers445 {
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
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();

		while (l1 != null) {
			s1.add(l1.val);
			l1 = l1.next;
		}

		while (l2 != null) {
			s2.add(l2.val);
			l2 = l2.next;
		}

		ListNode head = new ListNode();
		int carry = 0;
		while (s1.size() > 0 || s2.size() > 0 || carry > 0) {
			int val1 = 0;
			int val2 = 0;
			if (s1.size() > 0) {
				val1 = s1.pop();
			}

			if (s2.size() > 0) {
				val2 = s2.pop();
			}

			int mod = (val1 + val2 + carry) % 10;
			carry = (val1 + val2 + carry) / 10;

			addNode(head, new ListNode(mod));

		}

		return head.next;
	}

	private static void addNode(ListNode head, ListNode node) {
		node.next = head.next;
		head.next = node;
	}
}

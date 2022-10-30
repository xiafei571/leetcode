package am;

import common.ListNode;

public class IsPalindromeLinkedlist234O1Space {
	public boolean isPalindrome(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		fast = head;
		slow = reverse(slow);

		while (slow != null) {
			if (fast.val != slow.val)
				return false;
			fast = fast.next;
			slow = slow.next;
		}
		return true;

	}

	private static ListNode reverse(ListNode node) {
		ListNode pre = node;
		node = node.next;
		pre.next = null;

		while (node != null) {
			ListNode next = node.next;
			node.next = pre;

			pre = node;
			node = next;
		}

		return pre;
	}
}

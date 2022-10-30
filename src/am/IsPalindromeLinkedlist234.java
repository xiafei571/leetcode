package am;

import java.util.Stack;

import common.ListNode;

public class IsPalindromeLinkedlist234 {
	public boolean isPalindrome(ListNode head) {
		Stack<ListNode> stack = new Stack<>();
		ListNode node = head;
		while (node != null) {
			stack.push(node);
			node = node.next;
		}

		while (head != null) {
			if (!stack.isEmpty()) {
				ListNode topNode = stack.pop();
				if (topNode.val != head.val)
					return false;
			} else {
				return false;
			}

			head = head.next;
		}

		return true;
	}
}

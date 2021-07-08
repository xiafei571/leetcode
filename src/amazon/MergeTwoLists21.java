package amazon;

public class MergeTwoLists21 {

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

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode pre = new ListNode();
		ListNode head = pre;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {// 1 3 4, 3 4 5
				head.next = l1;
				l1 = l1.next;
			} else {
				head.next = l2;
				l2 = l2.next;
			}

			head = head.next;
		}
		if (l1 == null) {
			head.next = l2;
		} else {
			head.next = l1;
		}
		return pre.next;
	}
}

package am;

public class SwapPairs {
	static class ListNode {
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

		@Override
		public String toString() {
			return "ListNode [val=" + val + ", next=" + next + "]";
		}
		
	}
	
	public static void main(String[] args) {
		//[1,2,3,4]
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		swapPairs(n1);
	}

	public static ListNode swapPairs(ListNode head) {
		ListNode currHead = new ListNode();
		currHead.next = head;
		ListNode resHead = currHead;
		while (currHead != null && currHead.next != null) {
			swapPair(currHead);
			currHead = currHead.next.next;
		}

		return resHead.next;
	}

	public static void swapPair(ListNode head) {
		ListNode left = head.next;
		ListNode right = head.next.next;

		if (left == null || right == null) {
			return;
		} else {
			head.next = right;
			left.next = right.next;
			right.next = left;
		}
	}
}

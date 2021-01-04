package algo.expert;

public class RemoveKthNodeFromEnd {
	public static void removeKthNodeFromEnd(LinkedList head, int k) {
		// Write your code here.
		LinkedList a = head;
		LinkedList b = head;
		while (k > 0) {
			a = a.next;
			k--;
		}

		if (a == null) {
			head.value = head.next.value;
			head.next = head.next.next;
			return;
		}

		while (a.next != null) {
			a = a.next;
			b = b.next;
		}

		b.next = b.next.next;
	}

	static class LinkedList {
		int value;
		LinkedList next = null;

		public LinkedList(int value) {
			this.value = value;
		}
	}
}

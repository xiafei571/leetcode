package algo.expert;

public class RemoveDuplicatesFromLinkedList {
	// This is an input class. Do not edit.
	public static class LinkedList {
		public int value;
		public LinkedList next;

		public LinkedList(int value) {
			this.value = value;
			this.next = null;
		}
	}

	public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
		// Write your code here.
		LinkedList head = linkedList;
		while (linkedList.next != null) {
			int curr = linkedList.value;
			int next = linkedList.next.value;
			if (curr == next) {
				linkedList.next = linkedList.next.next;
			} else {
				linkedList = linkedList.next;
			}
		}
		return head;
	}
}

package algo.expert;

public class SumOfLinkedLists {

	// This is an input class. Do not edit.
	public static class LinkedList {
		public int value;
		public LinkedList next;

		public LinkedList(int value) {
			this.value = value;
			this.next = null;
		}
	}

	public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
		// Write your code here.

		LinkedList head = new LinkedList(0);
		LinkedList curr = head;

		LinkedList nodeOne = linkedListOne;
		LinkedList nodeTwo = linkedListTwo;

		int carry = 0;
		while (nodeOne != null || nodeTwo != null || carry != 0) {
			int valOne = nodeOne == null ? 0 : nodeOne.value;
			int valTwo = nodeTwo == null ? 0 : nodeTwo.value;

			int sum = valOne + valTwo + carry;
			LinkedList newNode = new LinkedList(sum % 10);
			curr.next = newNode;
			curr = curr.next;
			carry = sum / 10;

			if (nodeOne != null) {
				nodeOne = nodeOne.next;
			}

			if (nodeTwo != null) {
				nodeTwo = nodeTwo.next;
			}

		}

		return head.next;
	}
}

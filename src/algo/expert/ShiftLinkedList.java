package algo.expert;

public class ShiftLinkedList {
	public static void main(String[] args) {
		LinkedList head = new LinkedList(0);
		head.next = new LinkedList(1);
		head.next.next = new LinkedList(2);
		head.next.next.next = new LinkedList(3);
		head.next.next.next.next = new LinkedList(4);
		head.next.next.next.next.next= new LinkedList(5);
		
		LinkedList ll = shiftLinkedList(head, 2);
		while(ll!= null) {
			System.out.print(ll.value);
			ll = ll.next;
		}
	}
	
	public static LinkedList shiftLinkedList(LinkedList head, int k) {
		// Write your code here.
		int length = 1;
		LinkedList curr = head;
		while (curr.next != null) {
			curr = curr.next;
			length++;
		}
		System.out.println(length);
		LinkedList tail = curr;
		curr.next = head;
		int move = 0;

		if (k > 0) {
			k = k % length;
			move = length - k;
		} else if (k < 0) {
			k = (0 - k) % length;
			move = k;
		}

		if (move == 0) {
			tail.next = null;
		} else {
			for (int i = 0; i < move; i++) {
				tail = tail.next;
			}
			head = tail.next;
			tail.next = null;
		}

		return head;
	}

	static class LinkedList {
		public int value;
		public LinkedList next;

		public LinkedList(int value) {
			this.value = value;
			next = null;
		}
	}
}

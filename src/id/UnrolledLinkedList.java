package id;

public class UnrolledLinkedList {
	/*
	 * ⼀个链表 每个node有一个array， 让你实现 查找 插入
	 * 
	 * Given a LinkedList, every node contains a array. Every element of the array
	 * is char implement two functions 
	 * 1. get(int index) find the char at the index
	 * 2. insert(char ch, int index) insert the char to the index 考虑corner case
	 * 
	 * A = N(total) / 5;
	 * get() Time: O(A) Space: O(1)
	 * insert() Time: O(A) Space: O(1)
	 * 
	 * Follow up1: 问如何更快，没答出来，说是用rope可以，Rope在字符串中进行插入和删除更快O（logn）
	 * rope 可以替代string来处理超长字符串的相关操作，比如联接，插入，删除，因此它常用于text editor这样的应用中
	 * 
	 * 如果这个node满了怎么办？我说这个node一共有5个数，如果这个数出现在第2位，我就把后面4个数都放进一个新node里，然后把这个node放到当前node的后面。小哥说有没有什么更好的方法，我说可以在这个node后面多加一个node，把一个多余的数放进新node里，而不是后面所有的数，小哥问我trade off是什么。
	 * 然后这里我就听成了，或者说我感觉成了，最后才明白，小哥同意了我的做法，只是想让我分析一下trade off（时间复杂度），然后实现。当时我才恍然大悟，浪费了10分钟之久，赶紧写代码，最后时间太紧，写了个bug，也没写完，小哥说可以了，剩下的不难，不用写了。

	 */
	class Node {
		char[] chars;
		int len;
		Node next;

		public Node() {
			chars = new char[5];
			len = 0;
			next = null;
		}
	}

	class UnRolledList {
		Node head;
		int totalLen;

		public UnRolledList(Node head, int total) {
			this.head = head;
			this.totalLen = total;
		}
	}

	private UnRolledList list;

	public UnrolledLinkedList() {
		list = new UnRolledList(new Node(), 100);
	}

	public char get(int index) {
		Node head = list.head;
		int total = list.totalLen;
		// basic check
		if (head == null || total <= 0 || index >= total) {
			return ' ';
		}

		int idx_link = index / 5;
		int idx_arr = index % 5;

		for (int i = 0; i < idx_link; i++) {
			if (head.next != null) {
				head = head.next;
			} else {
				return ' ';
			}
		}
		return head.chars[idx_arr];
	}

	public void insert(char ch, int index) {
		Node head = list.head;
		int total = list.totalLen;
		// basic check
		if (head == null || total <= 0 || index >= total) {
			return;
		}

		int idx_link = index / 5;
		int idx_arr = index % 5;

		for (int i = 0; i < idx_link; i++) {
			if (head.next != null) {
				head = head.next;
			} else {
				head.next = new Node();
				head = head.next;
			}
		}

		if (head.len < 5) {
			for (int i = head.len; i > idx_arr; i--) {
				head.chars[i] = head.chars[i - 1];
			}

			head.chars[idx_arr] = ch;
			head.len++;
		} else {// is full
			Node newNode = new Node();
			for (int i = 0; i < head.len - idx_arr; i++) {
				newNode.chars[i] = head.chars[i + idx_arr];
				head.chars[i + idx_arr] = ' ';
				head.len--;
			}
			head.chars[idx_arr] = ch;
			head.len++;

			newNode.len = head.len - idx_arr;
			newNode.next = head.next;
			head.next = newNode;
		}
	}
}

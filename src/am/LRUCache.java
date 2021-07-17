package am;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	class DLinkedList {
		private int key;
		private int value;
		private DLinkedList pre;
		private DLinkedList next;

		public DLinkedList() {

		}

		public DLinkedList(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	private DLinkedList head;
	private DLinkedList tail;

	private int capacity;
	private int size;

	Map<Integer, DLinkedList> cache = new HashMap<Integer, DLinkedList>();

	public void addNode(DLinkedList node) {
		node.pre = head;
		node.next = head.next;

		head.next.pre = node;
		head.next = node;
	}

	public void removeNode(DLinkedList node) {
		DLinkedList pre = node.pre;
		DLinkedList next = node.next;
		pre.next = next;
		next.pre = pre;
	}

	public void moveToHead(DLinkedList node) {
		removeNode(node);
		addNode(node);
	}

	public DLinkedList popTail() {
		DLinkedList node = tail.pre;
		removeNode(node);
		return node;
	}

	public LRUCache(int capacity) {
		this.head = new DLinkedList();
		this.tail = new DLinkedList();
		head.next = tail;
		tail.pre = head;
		this.capacity = capacity;
		this.size = 0;
	}

	public int get(int key) {
		DLinkedList node = cache.get(key);

		if (node == null) {
			return -1;
		} else {
			moveToHead(node);
			return node.value;
		}
	}

	public void put(int key, int value) {
		if (cache.containsKey(key)) {
			DLinkedList node = cache.get(key);
			node.value = value; // update the value
			moveToHead(node);
		} else {
			DLinkedList newNode = new DLinkedList(key, value);
			cache.put(key, newNode);
			addNode(newNode);
			size++;
			if (size > capacity) {
				DLinkedList tailNode = popTail();
				cache.remove(tailNode.key);
				size--;
			}
		}
	}
}

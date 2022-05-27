package bytedance;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	class DLinkedNode {
		int key;
		int value;
		DLinkedNode prev;
		DLinkedNode next;
	}

	private Map<Integer, DLinkedNode> cache = new HashMap<>();
	private int size;
	private int capacity;
	private DLinkedNode head, tail;

	public LRUCache(int capacity) {
		this.size = 0;
		this.capacity = capacity;
		head = new DLinkedNode();
		tail = new DLinkedNode();
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		if (cache.containsKey(key)) {
			DLinkedNode node = cache.get(key);
			moveToHead(node);
			return node.value;
		}
		return -1;
	}

	public void put(int key, int value) {
		if (cache.containsKey(key)) {
			DLinkedNode node = cache.get(key);
			node.value = value;
			cache.put(key, node);
			moveToHead(node);
		} else {
			DLinkedNode newNode = new DLinkedNode();
			newNode.key = key;
			newNode.value = value;
			cache.put(key, newNode);
			addNode(newNode);
			size++;
			if (size > capacity) {
				DLinkedNode tail = popTail();
				cache.remove(tail.key);
				size--;
			}
		}

	}

	private void addNode(DLinkedNode node) { // head - node1 - node2
		node.prev = head;
		node.next = head.next;

		head.next.prev = node;
		head.next = node;
	}

	private void removeNode(DLinkedNode node) { // node0 - node1 - node2
		DLinkedNode prev = node.prev;
		DLinkedNode next = node.next;

		prev.next = next;
		next.prev = prev;
	}

	private void moveToHead(DLinkedNode node) {
		/**
		 * Move certain node in between to the head.
		 */
		removeNode(node);
		addNode(node);
	}

	private DLinkedNode popTail() {
		/**
		 * Pop the current tail.
		 */
		DLinkedNode res = tail.prev;
		removeNode(res);
		return res;
	}
}

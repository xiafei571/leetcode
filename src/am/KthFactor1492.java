package am;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthFactor1492 {
	public int kthFactor(int n, int k) {
		Queue<Integer> heap = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
		int sqrtN = (int) Math.sqrt(n);
		for (int i = 1; i < sqrtN + 1; i++) {
			if (n % i == 0) {
				heap.add(i);
				heapResize(heap, k);

				if (i != n / i) {
					heap.add(n / i);
					heapResize(heap, k);
				}
			}
		}

		return k > heap.size() ? -1 : heap.poll();

	}

	private static void heapResize(Queue<Integer> heap, int k) {
		if (heap.size() > k) {
			heap.remove();
		}
	}

	public int kthFactor_1(int n, int k) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < n / 2 + 1; i++) {
			if (n % i == 0) {
				list.add(i);
			}
		}
		list.add(n);

		return k > list.size() ? -1 : list.get(k - 1);
	}
}

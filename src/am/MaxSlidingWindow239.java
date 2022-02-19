package am;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxSlidingWindow239 {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length == 0 || k <= 0) {
			return new int[0];
		}

		int[] res = new int[nums.length - k + 1];
		int res_idx = 0;
		Deque<Integer> deque = new ArrayDeque<Integer>();
		for (int i = 0; i < nums.length; i++) {

			if (!deque.isEmpty() && deque.peek() <= i - k) {
				deque.pollFirst();
			}

			while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
				deque.pollLast();
			}

			deque.add(i);

			if (i >= k - 1) {
				res[res_idx] = nums[deque.peekFirst()];
				res_idx++;
			}
		}

		return res;
	}
}

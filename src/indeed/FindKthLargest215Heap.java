package indeed;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKthLargest215Heap {

	public static void main(String[] args) {
		System.out.println(findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
		System.out.println(findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4));
	}

	public static int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> priority = new PriorityQueue<Integer>(nums.length, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		
		for(int n : nums) {
			priority.add(n);
		}
		
		int result = 0;
		while(k > 0) {
			result = priority.poll();
			k--;
		}
		return result;
	}

}

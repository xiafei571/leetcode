package bb;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinMeetingRooms253 {
	public int minMeetingRooms(int[][] intervals) {
		// define heap
		PriorityQueue<Integer> allocator = new PriorityQueue<Integer>((a, b) -> a - b);
		// Sort the intervals by start time
		Arrays.sort(intervals, new Comparator<int[]>() {
			public int compare(final int[] a, final int[] b) {
				return a[0] - b[0];
			}
		});

		// Add the first meeting
		allocator.add(intervals[0][1]);
		// Iterate over remaining intervals
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] >= allocator.peek()) {
				allocator.poll();
			}
			allocator.add(intervals[i][1]);
		}
		return allocator.size();
	}
}

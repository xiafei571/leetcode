package am;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinMeetingRooms253 {
	public int minMeetingRooms(int[][] intervals) {// intervals = [[0,30],[5,10],[15,20]] output= 2
		if (intervals.length < 2) {
			return intervals.length;
		}

		Arrays.sort(intervals, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		PriorityQueue<Integer> rooms = new PriorityQueue<Integer>();// store end time
		rooms.add(intervals[0][1]);

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] < rooms.peek()) {// add new room
				rooms.add(intervals[i][1]);
			} else {
				rooms.poll();
				rooms.add(intervals[i][1]);
			}
		}

		return rooms.size();

	}
}

package ktng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals56 {
	public static int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

		List<Integer[]> res = new ArrayList<>();
		res.add(new Integer[] { intervals[0][0], intervals[0][1] });

		for (int i = 1; i < intervals.length; i++) {
			Integer[] pre = res.get(res.size() - 1);
			Integer[] curr = new Integer[] { intervals[i][0], intervals[i][1] };
			if (curr[0] > pre[1]) {
				res.add(curr);
			} else {
				pre[1] = Math.max(pre[1], curr[1]);
				res.set(res.size() - 1, pre);
			}
		}

		int[][] ans = new int[res.size()][2];
		for (int i = 0; i < ans.length; i++) {
			Integer[] pair = res.get(i);
			ans[i] = new int[] { pair[0], pair[1] };
		}

		return ans;
	}

	public static void main(String[] args) {
		int[][] input = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		//[[1,6],[8,10],[15,18]]
		int[][] res = merge(input);
		printIdleTime(res);
	}

	private static void printIdleTime(int[][] res) {
		int start = 0;
		int end = 0;

		List<Integer[]> idleTime = new ArrayList<>();
		for (int[] time : res) {
			if (end < time[0]) {
				idleTime.add(new Integer[] { start, time[0] });
				start = time[1] + 1;
				end = start;
			}
		}
		
		if(end < 24) {
			idleTime.add(new Integer[] {end, 24});
		}

		for (Integer[] time : idleTime) {
			System.out.println(" (" + time[0] + ":" + time[1] + ") ");
		}
		System.out.println();
	}
}

package am;

import java.util.ArrayList;
import java.util.List;

public class Merge56 {
	public int[][] merge(int[][] intervals) {
		// curr next
		// next[start] > curr[end] x -> add to result and curr = next, next = next.next
		// new curr = merger to min(start), max(end)

		if (intervals.length <= 1) {
			return intervals;
		}

		int i = 0;
		int j = 1;

		int[] curr = intervals[i];
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		while (j < intervals.length) {
			int[] next = intervals[j];
			if (j == intervals.length - 1) {// last one
				if (next[0] > curr[1]) {
					List<Integer> c = new ArrayList<Integer>();
					c.add(curr[0]);
					c.add(curr[1]);
					List<Integer> n = new ArrayList<Integer>();
					n.add(next[0]);
					n.add(next[1]);
					result.add(c);
					result.add(n);
				} else {
					List<Integer> m = new ArrayList<Integer>();
					m.add(Math.min(curr[0], next[0]));
					m.add(Math.max(curr[1], next[1]));
					result.add(m);
				}
			} else {

				if (next[0] > curr[1]) {
					List<Integer> c = new ArrayList<Integer>();
					c.add(curr[0]);
					c.add(curr[1]);
					List<Integer> n = new ArrayList<Integer>();
					n.add(next[0]);
					n.add(next[1]);
					result.add(c);
					result.add(n);
					i = j;
					curr = intervals[i];

				} else {
					curr[0] = Math.min(curr[0], next[0]);
					curr[1] = Math.max(curr[1], next[1]);
				}

				j++;
			}
		}

		int[][] ans = new int[result.size()][2];
		for (int k = 0; k < result.size(); k++) {
			ans[i] = new int[] { result.get(i).get(0), result.get(i).get(1) };
		}

		return ans;

	}
}

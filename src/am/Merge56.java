package am;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge56 {
	public int[][] merge(int[][] intervals) {
		// curr next
		// next[start] > curr[end] x -> add to result and curr = next, next = next.next
		// new curr = merger to min(start), max(end)

		if (intervals.length <= 1) {
			return intervals;
		}

		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		List<int[]> result = new ArrayList<int[]>();
		
		result.add(intervals[0]);
		for(int i = 1; i < intervals.length; i++) {
			int[] curr = intervals[i];
			int[] last = result.get(result.size() - 1);
			
			if(curr[0] > last[1]) {
				result.add(curr);
			}else {
				last[1] = Math.max(curr[1], last[1]);
			}
		}
		
		return result.toArray(new int[result.size()][2]);
	}
}

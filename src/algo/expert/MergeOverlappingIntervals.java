package algo.expert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingIntervals {
	public static int[][] mergeOverlappingIntervals(int[][] intervals) {
		//O(NlogN) time
		//O(N) space
		// Write your code here.
		// sorted -> (end >= start) -> overlap
		List<int[]> result = new ArrayList<int[]>();

		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

		int[] current = intervals[0];
		
		for (int i = 1; i < intervals.length; i++) {
			int[] next = intervals[i];
			int currentEnd = current[1];
			int nextStart = next[0];
			int nextEnd = next[1];
			
			if(currentEnd >= nextStart) {
				current[1] = Math.max(currentEnd, nextEnd);
			}else {
				result.add(new int[] {current[0], current[1]});
				current = intervals[i];
			}
			
			if(i == intervals.length-1) {
				result.add(new int[] {current[0], current[1]});
			}
		}

		return result.toArray(new int[result.size()][]);
	}

	public static void main(String[] args) {
		int[][] intervals = new int[][] { { 1, 2 }, { 3, 5 }, { 4, 7 }, { 6, 8 }, { 9, 10 } };
		mergeOverlappingIntervals(intervals);
	}

}

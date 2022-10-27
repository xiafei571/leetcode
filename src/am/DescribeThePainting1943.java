package am;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DescribeThePainting1943 {
	public List<List<Long>> splitPainting(int[][] segments) {
		Map<Integer, Long> line = new TreeMap<>();
		for (int[] segment : segments) {
			int start = segment[0];
			int end = segment[1];
			int color = segment[2];
			line.put(start, line.getOrDefault(start, 0L) + color);
			line.put(end, line.getOrDefault(end, 0L) - color);
		}

		List<List<Long>> res = new ArrayList<>();
		long left = 0;
		long sum = 0;
		for (int seg : line.keySet()) {
			// System.out.println(seg+":"+line.get(seg));
			if (sum > 0) {
				res.add(Arrays.asList(left, (long) seg, sum));
			}
			sum += line.get(seg);
			left = seg;
		}
		return res;
	}
}

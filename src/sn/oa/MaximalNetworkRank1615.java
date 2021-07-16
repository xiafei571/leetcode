package sn.oa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaximalNetworkRank1615 {

	public int maximalNetworkRank(int n, int[][] roads) {
		int[][] matrix = new int[n][n];
		int[] indegree = new int[n];

		for (int[] road : roads) {
			matrix[road[0]][road[1]] = 1;
			matrix[road[1]][road[0]] = 1;
			indegree[road[0]]++;
			indegree[road[1]]++;
		}

		int maxRank = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				int currRank = indegree[i] + indegree[j] - matrix[i][j];
				maxRank = Math.max(currRank, maxRank);
			}
		}
		return maxRank;
	}

	public int maximalNetworkRank2(int n, int[][] roads) {
		if (n == 0) {
			return 0;
		}

		if (roads.length == 0) {
			return 0;
		}
		Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();

		for (int[] road : roads) {
			Set<Integer> set0 = map.getOrDefault(road[0], new HashSet<Integer>());
			Set<Integer> set1 = map.getOrDefault(road[1], new HashSet<Integer>());
			set0.add(road[1]);
			set1.add(road[0]);

			map.put(road[0], set0);
			map.put(road[1], set1);
		}

		int maxRank = 0;
		for (int i = 0; i < n - 1; i++) {
			Set<Integer> set = map.getOrDefault(i, new HashSet<Integer>());
			for (int j = i + 1; j < n; j++) {
				int curr = set.size() + map.getOrDefault(j, new HashSet<Integer>()).size();
				if (set.contains(j)) {
					curr--;
				}
				maxRank = Math.max(curr, maxRank);
			}
		}
		return maxRank;

	}
}

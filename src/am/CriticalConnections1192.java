package am;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CriticalConnections1192 {
	Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
	int[] currStep;
	int[] minStep;

	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

		for (List<Integer> connection : connections) {
			Set<Integer> set0 = graph.getOrDefault(connection.get(0), new HashSet<Integer>());
			set0.add(connection.get(1));
			graph.put(connection.get(0), set0);

			Set<Integer> set1 = graph.getOrDefault(connection.get(1), new HashSet<Integer>());
			set1.add(connection.get(0));
			graph.put(connection.get(1), set1);
		}

		currStep = new int[n];
		minStep = new int[n];

		Arrays.fill(currStep, -1);
		Arrays.fill(minStep, -1);

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		dfs(0, -1, 0, result);
		return result;

	}

	private void dfs(int curr, int parent, int step, List<List<Integer>> result) {
		currStep[curr] = step;
		minStep[curr] = step;
		Set<Integer> neighbors = graph.get(curr);
		if (neighbors == null || neighbors.size() == 0) {
			return;
		}
		for (Integer neighbor : neighbors) {
			if (neighbor == parent) {
				continue;
			}

			if (currStep[neighbor] == -1) {
				dfs(neighbor, curr, step + 1, result);
				if (currStep[curr] < minStep[neighbor]) {
					List<Integer> critical = new ArrayList<Integer>();
					critical.add(curr);
					critical.add(neighbor);
					result.add(critical);
				}
			}

			minStep[curr] = Math.min(minStep[curr], minStep[neighbor]);
		}
	}
}

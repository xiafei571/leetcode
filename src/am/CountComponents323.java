package am;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountComponents323 {

	public static void main(String[] args) {
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 3, 4 } };
		System.out.println(countComponents(5, edges));
	}

	/**
	 * Here E = Number of edges, V = Number of vertices. Time complexity: O(E+V)
	 * Building the adjacency list will take O(E) operations, as we iterate over the
	 * list of edges once, and insert each edge into two lists.
	 * 
	 * @param n
	 * @param edges
	 * @return
	 */
	public static int countComponents(int n, int[][] edges) {
		int count = 0;
		int[] visited = new int[n];
		Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
		for (int[] edge : edges) {
			Set<Integer> set0 = graph.getOrDefault(edge[0], new HashSet<Integer>());
			set0.add(edge[1]);
			graph.put(edge[0], set0);

			Set<Integer> set1 = graph.getOrDefault(edge[1], new HashSet<Integer>());
			set1.add(edge[0]);
			graph.put(edge[1], set1);
		}

		for (int i = 0; i < n; i++) {
			if (visited[i] == 0) {
				count++;
				dfs(i, visited, graph);
			}
		}

		return count;
	}

	private static void dfs(int node, int[] visited, Map<Integer, Set<Integer>> graph) {
		visited[node] = 1;
		Set<Integer> neighbours = graph.get(node);
		if (neighbours == null) {
			return;
		}

		for (Integer neighbour : neighbours) {
			if (visited[neighbour] == 0) {
				dfs(neighbour, visited, graph);
			}
		}
	}

}

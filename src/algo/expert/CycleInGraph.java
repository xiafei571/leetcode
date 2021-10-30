package algo.expert;

public class CycleInGraph {
	public boolean cycleInGraph(int[][] edges) {
		// Write your code here.
		int[] visited = new int[edges.length];
		int[] visiting = new int[edges.length];
		for (int i = 0; i < edges.length; i++) {
			if (visited[i] == 0) {
				boolean containsCycle = dfs(visited, visiting, edges, i);
				if (containsCycle) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean dfs(int[] visited, int[] visiting, int[][] edges, int node) {
		visited[node] = 1;
		visiting[node] = 1;
		int[] neighbors = edges[node];
		for (int neighbor : neighbors) {
			if (visited[neighbor] == 0) {
				boolean containsCycle = dfs(visited, visiting, edges, neighbor);
				if (containsCycle) {
					return true;
				}
			}
			if (visiting[neighbor] == 1) {
				return true;
			}
		}

		visiting[node] = 0;
		return false;
	}
}

package bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class NetworkDelayTime743 {
	// Adjacency list
	Map<Integer, List<Integer[]>> adj = new HashMap<>();

	public int networkDelayTime(int[][] times, int n, int k) {
		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		for (int[] time : times) {
			int source = time[0];
			int dest = time[1];
			int traveTime = time[2];
			List<Integer[]> list = adj.getOrDefault(source, new ArrayList<Integer[]>());
			list.add(new Integer[] { traveTime, dest });
			adj.put(source, list);
		}

		dijkstra(dist, k);
		int res = -1;
		for (int i = 1; i <= n; i++) {
			res = Math.max(res, dist[i]);
		}

		return res == Integer.MAX_VALUE ? -1 : res;
	}

	private void dijkstra(int[] dist, int source) {// BFS+PQ
		PriorityQueue<Integer[]> pq = new PriorityQueue<Integer[]>((a, b) -> a[0] - b[0]);
		pq.add(new Integer[] { 0, source });

		dist[source] = 0;

		while (!pq.isEmpty()) {
			Integer[] top = pq.poll();
			int curTime = top[0];
			int curNode = top[1];

			if (curTime > dist[curNode]) {
				continue;
			}

			if (!adj.containsKey(curNode)) {
				continue;
			}

			for (Integer[] edge : adj.get(curNode)) {
				int time = edge[0];
				int neighbor = edge[1];
				if (dist[neighbor] > curTime + time) {
					dist[neighbor] = curTime + time;
					pq.add(new Integer[] { dist[neighbor], neighbor });
				}
			}
		}

	}
}

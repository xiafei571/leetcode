package indeed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class GitVersion {
	/*
	 * git commit的题，也是面经题。第一问给一个commit(node)，BFS输出 所有commits(nodes)。 
	 * 第二问，两个commits(nodes)，找到他们的最近的公共parent，
	 * 就是先BFS⼀个，然后⽤用map记录下其各个parent到这个
	 * commit(node)的距离，然后BFS第二个commit(node)，碰到在map里的node，就算一个总距离，然后更新最短距离和的点，最后最短距离和的点就是结果了，写完面试官也表示很满意。这个注意解释下BFS的复杂度为什么
	 * 是O(V+E)，他会问为什么不是O(V)之类的。
	 */

	public List<Integer> findCommits(int[][] commits) {
		List<Integer> result = new ArrayList<Integer>();
		Map<Integer, Integer> indegrees = new HashMap<Integer, Integer>();
		Map<Integer, Set<Integer>> neighborMap = new HashMap<Integer, Set<Integer>>();
		
		for(int[] commit : commits) {//[from, to]
			//add 0 indegree node
			if(!indegrees.containsKey(commit[0])) {
				indegrees.put(commit[0], 0);
			}
			//add other node 
			indegrees.put(commit[1], indegrees.getOrDefault(commit[1], 0)+1);
			Set<Integer> neighbors = neighborMap.getOrDefault(commit[0], new HashSet<Integer>());
			neighbors.add(commit[1]);
			neighborMap.put(commit[0], neighbors);
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(Integer node : indegrees.keySet()) {
			if(indegrees.get(node) == 0) {
				queue.add(node);
			}
		}
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			result.add(cur);
			Set<Integer> neighbors = neighborMap.get(cur);
			if(neighbors != null && neighbors.size() > 0) {
				for(int neighbor : neighbors) {
					int indegree = indegrees.get(neighbor);
					indegree--;
					//update indegree
					indegrees.put(neighbor, indegree);
					if(indegree == 0) {
						queue.add(neighbor);
					}
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		GitVersion sol = new GitVersion();
		int[][] commits = new int[][] { { 0, 1 }, { 1, 3 }, { 3, 5 }, { 0, 2 }, { 2, 4 }, { 4, 5 } };

		List<Integer> result = sol.findCommits(commits);

		for (Integer elem : result) {
			System.out.println(elem);
		}
	}

	class GraphNode {
		int val;
		List<GraphNode> neighbors;
		GraphNode parent;

		public GraphNode(int val) {
			this.val = val;
			this.neighbors = new ArrayList<>();
		}
	}

}

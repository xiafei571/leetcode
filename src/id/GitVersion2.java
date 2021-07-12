package id;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class GitVersion2 {
	/*
	 * git commit的题，也是面经题。第一问给一个commit(node)，BFS输出 所有commits(nodes)。 
	 * 第二问，两个commits(nodes)，找到他们的最近的公共parent，
	 * 就是先BFS⼀个，然后⽤用map记录下其各个parent到这个
	 * commit(node)的距离，然后BFS第二个commit(node)，碰到在map里的node，就算一个总距离，然后更新最短距离和的点，最后最短距离和的点就是结果了，写完面试官也表示很满意。这个注意解释下BFS的复杂度为什么
	 * 是O(V+E)，他会问为什么不是O(V)之类的。
	 */

	public Integer findParents(int[][] commits, int node1, int node2) {
//		Map<Integer, Integer> outdegrees = new HashMap<Integer, Integer>();
		Map<Integer, Set<Integer>> parentsMap = new HashMap<Integer, Set<Integer>>();
		for(int[] commit : commits) {
			int from = commit[0];
			int to = commit[1];
			Set<Integer> parents = parentsMap.getOrDefault(to, new HashSet<Integer>());
			parents.add(from);
			parentsMap.put(to, parents);
			//update out
//			outdegrees.put(from, outdegrees.getOrDefault(from, 0) + 1);
		}
		
		Map<Integer, Integer> res1 = lca(node1, parentsMap);
		Map<Integer, Integer> res2 = lca(node2, parentsMap);
		
		int min = Integer.MAX_VALUE;
		Integer node = -1;
		for(Integer key : res2.keySet()) {
			if(res1.containsKey(key)) {
				if(res1.get(key) + res2.get(key) < min)
				min = res1.get(key) + res2.get(key);
				node = key;
			}
		}
		
		return node;
	}
	
	public Map<Integer, Integer> lca(int root, Map<Integer, Set<Integer>> parentsMap){
		Map<Integer, Integer> res = new HashMap<Integer, Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(root);
		int distance = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				int cur = queue.poll();
				res.put(cur, distance);
				Set<Integer> parents = parentsMap.get(cur);
				if(parents != null && parents.size() > 0) {
					for(Integer parent : parents) {
						queue.add(parent);
					}
				}
			}
			distance++;
		}
		
		
		//debug print
		for(Integer key : res.keySet()) {
			Integer val = res.get(key);
			System.out.print(key + ":" + val +" ");
		}
		System.out.println();
		return res;
	}

	public static void main(String[] args) {
		GitVersion2 sol = new GitVersion2();
		int[][] commits = new int[][] { { 0, 1 }, { 1, 3 }, { 3, 5 }, { 0, 2 }, { 2, 4 }, { 4, 5 } };

		int lca = sol.findParents(commits, 3, 4);
		System.out.println("lca node:" + lca);
	}

}

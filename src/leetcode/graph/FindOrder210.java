package leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FindOrder210 {
	/*
	 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
	 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
	 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。from 1 -> 0 to
	 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
	 */
	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		
		Map<Integer, Set<Integer>> adjacency = new HashMap<Integer, Set<Integer>>();
		int[] indegrees = new int[numCourses];
		
		for(int[] pair : prerequisites) {
			Set<Integer> neighbor = adjacency.getOrDefault(pair[1], new HashSet<Integer>());
			neighbor.add(pair[0]);
			adjacency.put(pair[1], neighbor);
			indegrees[pair[0]]++;
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i = 0; i < indegrees.length; i++) {
			if(indegrees[i] == 0) {
				queue.add(i);
			}
		}
		
		List<Integer> list = new ArrayList<Integer>();
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			list.add(cur);
			
			if(adjacency.containsKey(cur)) {
				Set<Integer> neighbors = adjacency.get(cur);
				for(int neighbor : neighbors) {
					indegrees[neighbor]--;
					if(indegrees[neighbor] == 0) {
						queue.add(neighbor);
					}
				}
			}
		}
		
		int[] res =  new int[numCourses];
		if(list.size() == numCourses) {
			for(int i = 0; i < numCourses; i++) {
				res[i] = list.get(i);
			}
			return res;
		}
		return new int[0];
	}

	public static void main(String[] args) {
		int numCourses = 6;
		int[][] prerequisites = new int[][] { { 3, 1 }, { 3, 2 }, { 4, 5 } };
		int[] result = findOrder(numCourses, prerequisites);
		for (int i : result) {
			System.out.print(i);
		}
		System.out.println();
	}
}

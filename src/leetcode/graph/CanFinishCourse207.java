package leetcode.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CanFinishCourse207 {
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		//hashmap to store pre_require
		Map<Integer, Set<Integer>> adjacency = new HashMap<Integer,  Set<Integer>>();
		int[] indegrees = new int[numCourses];
		
		for(int[] pair : prerequisites) {// pair:to->from
			Set<Integer> set = adjacency.getOrDefault(pair[1], new HashSet<Integer>());
			set.add(pair[0]);
			adjacency.put(pair[1], set);
			indegrees[pair[0]]++;
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i = 0; i < indegrees.length; i++) {
			if(indegrees[i] == 0) {
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			numCourses--;
			Set<Integer> neighbors = adjacency.get(cur);
			if(neighbors == null || neighbors.size() == 0) {
				continue;
			}else {
				for(int neighbor : neighbors) {
					indegrees[neighbor]--;
					if(indegrees[neighbor]== 0) {
						queue.add(neighbor);
					}
				}
			}
		}
		
		return numCourses == 0;

    }
	
	public static void main(String[] args) {
		int numCourses = 6;
		int[][] prerequisites = new int[][] {{3,1},{3,2},{4, 5}};
		System.out.println(canFinish(numCourses, prerequisites));
		
	}
}

package am;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FindOrder210 {
	// numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
	// [0,2,1,3]

	public static void main(String[] args) {

		String a = "15.94";
		String b = "16.00";

		float fa = Float.valueOf(a);
		float fb = Float.valueOf(b);
		
		int ia = (int) (fa * 100);
		int ib = (int) (fb * 100);
		System.out.println(ia - ib);

		int[] array = findOrder(2, new int[][] { { 1, 0 } });
		System.out.println(array.length);
	}

	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] indegree = new int[numCourses];
		Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();

		for (int[] pre : prerequisites) {
			indegree[pre[0]]++;
			Set<Integer> childs = graph.getOrDefault(pre[1], new HashSet<Integer>());
			childs.add(pre[0]);
			graph.put(pre[1], childs);
		}

		Queue<Integer> queue = new LinkedList<Integer>();

		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}

		int[] result = new int[numCourses];
		int idx = 0;
		while (queue.size() > 0) {
			int top = queue.poll();
			result[idx] = top;
			idx++;

			Set<Integer> childs = graph.get(top);
			if (childs != null && childs.size() > 0) {
				for (int child : childs) {
					indegree[child]--;
					if (indegree[child] == 0) {
						queue.add(child);
					}
				}
			}
		}

		if (idx == numCourses) {
			return result;
		}

		return new int[] {};
	}
}

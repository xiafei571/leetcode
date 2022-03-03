package bb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseSchedule207 {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		Map<Integer, Integer> indegree = new HashMap<Integer, Integer>();
		Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < numCourses; i++) {
			indegree.put(i, 0);
		}

		for (int[] pre : prerequisites) {
			List<Integer> list = graph.getOrDefault(pre[1], new ArrayList<Integer>());
			list.add(pre[0]);
			graph.put(pre[1], list);
			indegree.put(pre[0], indegree.get(pre[0]) + 1);
		}

		// for(Integer key : graph.keySet()){
		// System.out.println(key +":" + graph.get(key));
		// }

		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < numCourses; i++) {
			if (indegree.get(i) == 0) {
				queue.add(i);
			}
		}

		List<Integer> courses = new ArrayList<Integer>();
		while (!queue.isEmpty()) {
			Integer course = queue.poll();
			courses.add(course);
			List<Integer> list = graph.getOrDefault(course, new ArrayList<Integer>());
			if (list.size() == 0) {
				continue;
			}
			for (Integer i : list) {
				int in = indegree.get(i);
				if (in > 0) {
					in--;
					if (in == 0) {
						queue.add(i);
					}
					indegree.put(i, in);
				} else {
					return false;
				}
			}
		}
		return courses.size() == numCourses;

	}
}

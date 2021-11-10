package am;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CourseSchedule207 {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		// [0,1] 1->0
		Map<Integer, Integer> indegrees = new HashMap<Integer, Integer>();
		Map<Integer, Set<Integer>> prerequisitesMap = new HashMap<Integer, Set<Integer>>();

		for (int i = 0; i < numCourses; i++) {
			indegrees.put(i, 0);
		}

		for (int[] prerequisite : prerequisites) {
			Set<Integer> set = prerequisitesMap.getOrDefault(prerequisite[1], new HashSet<Integer>());
			set.add(prerequisite[0]);
			prerequisitesMap.put(prerequisite[1], set);

			int indegree = indegrees.get(prerequisite[0]);
			indegree++;
			indegrees.put(prerequisite[0], indegree);
		}

		Queue<Integer> queue = new LinkedList<Integer>();
		for (Integer key : indegrees.keySet()) {
			if (indegrees.get(key) == 0) {
				queue.add(key);
			}
		}

		List<Integer> result = new ArrayList<Integer>();
		while (!queue.isEmpty()) {
			Integer prerequire = queue.poll();
			result.add(prerequire);
			if (prerequisitesMap.containsKey(prerequire)) {
				Set<Integer> set = prerequisitesMap.get(prerequire);
				for (Integer course : set) {
					int indegree = indegrees.get(course);
					indegree--;
					indegrees.put(course, indegree);
					if (indegree == 0) {
						queue.add(course);
					}
				}
			}
		}

		return result.size() == numCourses;
	}
}

package algo.expert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class TopologicalSort {
	
	public static void main(String[] args) {
		/*
		 * "deps": [
    [1, 2],
    [1, 3],
    [3, 2],
    [4, 2],
    [4, 3]
  ],
  "jobs": [1, 2, 3, 4]
		 */
		List<Integer> jobs = new ArrayList<Integer>();
		List<Integer[]> deps = new ArrayList<Integer[]>();
		jobs.add(1);
		jobs.add(2);
		jobs.add(3);
		jobs.add(4);
		
		deps.add(new Integer[] {1, 2});
		deps.add(new Integer[] {1, 3});
		deps.add(new Integer[] {3, 2});
		deps.add(new Integer[] {4, 2});
		deps.add(new Integer[] {4, 3});
		List<Integer> result = topologicalSort(jobs, deps);
		System.out.println(result.size());
	}
	public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
		// Write your code here.
		if (jobs == null || jobs.size() == 0) {
			return new ArrayList<Integer>();
		}

		Map<Integer, Set<Integer>> prerequisite = new HashMap<Integer, Set<Integer>>();
		Map<Integer, Integer> indegreee = new HashMap<Integer, Integer>();

		for (Integer job : jobs) {
			indegreee.put(job, 0);
		}

		for (Integer[] dep : deps) {
			Integer pre = dep[0];
			Integer job = dep[1];
			Set<Integer> set = prerequisite.getOrDefault(pre, new HashSet<Integer>());
			set.add(job);
			prerequisite.put(pre, set);
			indegreee.put(job, indegreee.get(job) + 1);
		}

		Queue<Integer> queue = new LinkedList<Integer>();
		for (Integer job : indegreee.keySet()) {
			if (indegreee.get(job) == 0) {
				queue.add(job);
			}
		}

		List<Integer> result = new ArrayList<Integer>();
		if (queue.isEmpty()) {
			return result;
		} else {
			while (!queue.isEmpty()) {
				Integer job = queue.poll();
				result.add(job);
				Set<Integer> set = prerequisite.get(job);
				if(set != null) {
					for (Integer next : set) {
						Integer in = indegreee.get(next) - 1;
						indegreee.put(next, in);
						if (in == 0) {
							queue.add(next);
						}
					}
				}
			}
		}

		if (result.size() != jobs.size()) {
			return new ArrayList<Integer>();
		}

		return result;

	}
}

package kt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ParentChild2 {
	/*
	 * Question 2) Given the same parent-child relationship as above and 2
	 * individual IDs ind1 and ind2, find if ind1 has any common ancestors with
	 * ind2. Input: [(1, 3), (2, 3), (3, 6), (5, 6), (5, 7), (4, 5),(4, 8), (4, 9),
	 * (9, 11), (14, 4), (13, 12), (12, 9)], ind1 = 6, ind2 = 9 Output: true
	 * 
	 * Input: [(1, 3), (2, 3), (3, 6), (5, 6), (5, 7), (4, 5),(4, 8), (4, 9), (9,
	 * 11), (14, 4), (13, 12), (12, 9)], ind1 = 3, ind2 = 1 Output: false
	 * 
	 */
	public static void main(String[] args) {
		int[][] input1 = { { 1, 3 }, { 2, 3 }, { 3, 6 }, { 5, 6 }, { 5, 7 }, { 4, 5 }, { 4, 8 }, { 4, 9 }, { 9, 11 },
				{ 14, 4 }, { 13, 12 }, { 12, 9 } };
		int[][] input2 = { { 1, 4 }, { 1, 5 }, { 2, 5 }, { 3, 6 }, { 6, 7 } };
		System.out.println(commonParents(input1, 6, 2));
		System.out.println(commonParents(input1, 3, 2));
		
		System.out.println(commonParents(input2, 5, 6));
		System.out.println(commonParents(input2, 4, 5));
		System.out.println(commonParents(input2, 6, 7));

	}

	private static boolean commonParents(int[][] input, int ind1, int ind2) {
//		Map<Integer, Integer> outdegree = new HashMap<Integer, Integer>();
		Map<Integer, Set<Integer>> childToParents = new HashMap<Integer, Set<Integer>>();

		for (int[] pair : input) {
			Integer parent = pair[0];
			Integer child = pair[1];
			Set<Integer> parents = childToParents.getOrDefault(child, new HashSet<Integer>());
			parents.add(parent);
			childToParents.put(child, parents);
		}

		List<Integer> list1 = getParents(ind1, childToParents);
		List<Integer> list2 = getParents(ind2, childToParents);
		Set<Integer> set1 = new HashSet<Integer>(list1);
		boolean res = false;
		for (Integer parent : list2) {
			if (set1.contains(parent)) {
				res = true;
				System.out.println(parent);
			}
		}
		return res;
	}

	private static List<Integer> getParents(int ind1, Map<Integer, Set<Integer>> childToParents) {
		Queue<Integer> queue = new LinkedList<Integer>();
		List<Integer> parentsOfInd1 = new ArrayList<Integer>();
		queue.add(ind1);
		while (!queue.isEmpty()) {
			Integer child = queue.poll();
			parentsOfInd1.add(child);
			Set<Integer> parents = childToParents.get(child);
			if(parents == null || parents.size() == 0) {
				continue;
			}
			for (Integer parent : parents) {
				if (parentsOfInd1.contains(parent))
					continue;
				queue.add(parent);
			}
		}

		return parentsOfInd1;
	}
}

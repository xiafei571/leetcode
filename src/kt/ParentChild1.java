package kt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParentChild1 {
	/*
	 * Given a parent-child relationship in the form of [[parent1, child1],
	 * [parent2, child2], ...[parentX, childX]], return a list of all individuals
	 * who have no parents and all individuals who have exactly 1 parent Sample
	 * Input: [(1, 3), (2, 3), (3, 6), (5, 6), (5, 7), (4, 5),(4, 8), (4, 9), (9,
	 * 11), (14, 4), (13, 12), (12, 9)]
	 * 
	 * Output: [[14, 13, 1, 12], [2, 4, 5, 8, 7, 11]]
	 * 
	 */
	public static void main(String[] args) {
		int[][] input = { { 1, 3 }, { 2, 3 }, { 3, 6 }, { 5, 6 }, { 5, 7 }, { 4, 5 }, { 4, 8 }, { 4, 9 }, { 9, 11 },
				{ 14, 4 }, { 13, 12 }, { 12, 9 } };
		List<Integer> list1 = question1(input, 0);
		List<Integer> list2 = question1(input, 1);

		for (Integer child : list1) {
			System.out.print(child + " ");
		}
		System.out.println();
		for (Integer child : list2) {
			System.out.println(child + " ");
		}
		System.out.println();

		int[][] input2 = { { 1, 4 }, { 1, 5 }, { 2, 5 }, { 3, 6 }, { 6, 7 } };
		List<Integer> list3 = question1(input2, 0);
		List<Integer> list4 = question1(input2, 1);
		for (Integer child : list3) {
			System.out.print(child + " ");
		}
		System.out.println();

		for (Integer child : list4) {
			System.out.print(child + " ");
		}
		System.out.println();

	}

	private static List<Integer> question1(int[][] input, int parentCnt) {
//		Map<Integer, Set<Integer>> relation = new HashMap<Integer, Set<Integer>>();
		Map<Integer, Integer> indegree = new HashMap<Integer, Integer>();
		for (int[] pair : input) {
			Integer parent = pair[0];
			Integer child = pair[1];
			if (!indegree.containsKey(parent)) {
				indegree.put(parent, 0);
			}

			Integer cnt = indegree.getOrDefault(child, 0);
			indegree.put(child, cnt + 1);
		}

		List<Integer> res = new ArrayList<Integer>();
		for (Integer child : indegree.keySet()) {
			if (indegree.get(child) == parentCnt) {
				res.add(child);
			}
		}

		return res;
	}
}

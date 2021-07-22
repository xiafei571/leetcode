package am;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermuteUnique4647 {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 3 };
		printList(permute(nums));
		printList(permuteUnique(nums));
	}

	private static void printList(List<List<Integer>> lists) {
		for (List<Integer> list : lists) {
			for (Integer i : list) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Set<Integer> visited = new HashSet<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		dfs(nums, visited, list, result);
		return result;
	}

	private static void dfs(int[] nums, Set<Integer> visited, List<Integer> list, List<List<Integer>> result) {
		List<Integer> curr = new ArrayList<Integer>(list);
		if (curr.size() == nums.length) {
			result.add(curr);
			return;
		}

		for (int num : nums) {
			if (!visited.contains(num)) {
				curr.add(num);
				visited.add(num);
				dfs(nums, visited, curr, result);
				curr.remove(curr.size() - 1);
				visited.remove(num);
			}
		}
	}

	public static List<List<Integer>> permuteUnique(int[] nums) {
		int[] visited = new int[nums.length];
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		dfs(nums, 0, visited, list, result);
		return result;
	}

	private static void dfs(int[] nums, int idx, int[] visited, List<Integer> list, List<List<Integer>> result) {
		List<Integer> curr = new ArrayList<Integer>(list);
		if (idx == nums.length) {
			result.add(curr);
		}

		for (int i = 0; i < nums.length; i++) {
			if (visited[i] == 1) {
				continue;
			}

			if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0) {
				continue;
			}

			visited[i] = 1;
			curr.add(nums[i]);
			dfs(nums, idx + 1, visited, curr, result);
			curr.remove(curr.size() - 1);
			visited[i] = 0;
		}
	}
}

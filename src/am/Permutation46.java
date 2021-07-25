package am;

import java.util.ArrayList;
import java.util.List;

public class Permutation46 {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		printList(permute(nums));
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
		int[] visited = new int[nums.length];
		List<Integer> curr = new ArrayList<Integer>();
		dfs(0, nums, curr, result, visited);
		return result;
    }

    	private static void dfs(int idx, int[] nums, List<Integer> curr, List<List<Integer>> result, int[] visited) {
		if(idx == nums.length) {
			result.add(new ArrayList<Integer>(curr));
		}
		
		for(int i = 0; i < nums.length; i++) {
			if(visited[i] == 1) {
				continue;
			}
			
			visited[i] = 1;
			curr.add(nums[i]);
			dfs(idx+1, nums, curr, result, visited);
			visited[i] = 0;
			curr.remove(curr.size() -1);
		}
	}
}

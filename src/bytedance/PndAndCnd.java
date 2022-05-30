package bytedance;

import java.util.ArrayList;
import java.util.List;

public class PndAndCnd {

	public static void main(String[] args) {
		int[] input = {1,2,3};
		
		List<List<Integer>> pnd = new ArrayList<>();
		List<Integer> curr_pnd = new ArrayList<>();
		boolean[] used = new boolean[input.length]; 
		
		p(input, 0, 3, used, curr_pnd, pnd);
		
		for(List<Integer> list : pnd) {
			for(int i : list) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
		
		
		System.out.println("--------");
		
		List<List<Integer>> cnd = new ArrayList<>();
		List<Integer> curr_cnd = new ArrayList<>();
		
		c(input, 0, 2, 0, curr_cnd, cnd);
		
		for(List<Integer> list : cnd) {
			for(int i : list) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
	
	//P(n, d)
	private static void p(int[] nums, int d, int n, boolean[] used, List<Integer> curr, List<List<Integer>> res){
		if(d == n) {
			res.add(new ArrayList<>(curr));
			return;
		}
		
		for(int i = 0; i < nums.length; i++) {
			if(used[i]) {
				continue;
			}
			
			curr.add(nums[i]);
			used[i] = true;
			p(nums, d+1, n, used, curr, res);
			curr.remove(curr.size() - 1);
			used[i] = false;
		}
	}
	
	//C(n, d)
	private static void c(int[] nums, int d, int n, int idx, List<Integer> curr, List<List<Integer>> res){
		if(d == n) {
			res.add(new ArrayList<>(curr));
			return;
		}
		
		for(int i = idx; i < nums.length; i++) {
			curr.add(nums[i]);
			c(nums, d+1, n, i+1, curr, res);
			curr.remove(curr.size() - 1);
		}
	}
	
}

package bytedance;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum39 {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> curr = new ArrayList<>();

		dfs(candidates, target, 0, curr, res);

		return res;
	}

	private void dfs(int[] candidates, int remain, int idx, List<Integer> curr, List<List<Integer>> res) {
		if (remain == 0) {
			res.add(new ArrayList<>(curr));
		}

		for (int i = idx; i < candidates.length; i++) {
			int num = candidates[i];
			if (num > remain) {
				continue;
			}

			curr.add(num);
			dfs(candidates, remain - num, i, curr, res);
			curr.remove(curr.size() - 1);
		}
	}
}

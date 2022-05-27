package bytedance;

public class JumpGame45 {
	public int jump(int[] nums) {
		// return jumpHelper(0, nums);
		return jump2(nums);
	}

	public int jump2(int[] nums) {//O(N)
		int next = 0;
		int res = 0;
		int curEnd = 0;

		for (int i = 0; i < nums.length - 1; i++) {
			next = Math.max(next, i + nums[i]);
			if (i == curEnd) {
				res++;
				curEnd = next;
			}
		}

		return res;
	}

	private int jumpHelper(int idx, int[] nums) {// O(N^2)

		if (idx >= nums.length - 1) {
			return 0;
		}

		if (idx + nums[idx] >= nums.length - 1) {
			return 1;
		}

		int res = nums.length;

		for (int i = 1; i < nums[idx] + 1; i++) {
			res = Math.min(res, jumpHelper(idx + i, nums) + 1);
			// System.out.println(res+","+idx);
		}

		return res;
	}
}

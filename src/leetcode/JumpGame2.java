package leetcode;

public class JumpGame2 {
	public int jump(int[] nums) {
		int[] jumps = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			int step = nums[i];
			while (step > 0) {
				if (i + step >= nums.length) {
					step--;
					continue;
				} else if (jumps[i + step] == 0) {
					jumps[i + step] = jumps[i] + 1;
				} else {
					jumps[i + step] = Math.min(jumps[i + step], jumps[i] + 1);
				}
				step--;
			}
		}

		return jumps[nums.length - 1];

	}
}

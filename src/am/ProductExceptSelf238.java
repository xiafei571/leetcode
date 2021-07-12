package am;

public class ProductExceptSelf238 {
	public int[] productExceptSelf(int[] nums) {
		//238. 除自身以外数组的乘积
		// [1,1,2,6]
		// [24,12,4,1]
		int[] L = new int[nums.length];
		int[] R = new int[nums.length];

		L[0] = 1;
		R[nums.length - 1] = 1;
		for (int i = 1; i < nums.length; i++) {
			L[i] = nums[i - 1] * L[i - 1];
		}

		for (int j = nums.length - 1; j > 0; j--) {
			R[j - 1] = nums[j] * R[j];
		}

		int[] res = new int[nums.length];
		for (int i = 0; i < res.length; i++) {
			res[i] = L[i] * R[i];
		}

		return res;
	}
}

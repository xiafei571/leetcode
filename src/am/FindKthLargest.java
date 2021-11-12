package am;

public class FindKthLargest {
	public int findKthLargest(int[] nums, int k) {
		return qucikSelect(nums, k - 1, 0, nums.length - 1);
	}

	public int qucikSelect(int[] nums, int k, int left, int right) {
		int p = partition(nums, left, right);
		if (p == k) {
			return nums[p];
		} else if (p > k) {
			return qucikSelect(nums, k, left, p - 1);
		} else {
			return qucikSelect(nums, k, p + 1, right);
		}
	}

	private int partition(int[] nums, int left, int right) {
		int p = nums[right];// partition value
		int i = left;// partition index
		for (int j = left; j < right; j++) {
			if (nums[j] > p) {
				swap(nums, i, j);
				i++;
			}
		}
		swap(nums, i, right);
		return i;
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}

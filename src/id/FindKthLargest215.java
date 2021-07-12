package id;

public class FindKthLargest215 {

	public static void main(String[] args) {
		System.out.println(findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
		System.out.println(findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4));
	}

	public static int findKthLargest(int[] nums, int k) {
		return quickSelect(nums, 0, nums.length - 1, k-1);
	}

	private static int quickSelect(int[] nums, int left, int right, int k) {
		int p = partition(nums, left, right);
		if (p == k) {
			return nums[p];
		} else if (p > k) {//left
			return quickSelect(nums, left, p - 1, k);
		} else {//right
			return quickSelect(nums, p + 1, right, k);
		}
	}

	private static int partition(int[] nums, int left, int right) {
		int p = nums[right];
		int i = left;
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

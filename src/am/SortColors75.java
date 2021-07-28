package am;

public class SortColors75 {
	public void sortColors(int[] nums) {
		if(nums.length < 2) {
			return;
		}
		
		int idx = 0;

		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == 0) {
				swap(nums, idx, i);
				idx++;
			}
		}
		
		for(int j = idx; j < nums.length; j++) {
			if(nums[j] == 1) {
				swap(nums, idx, j);
				idx++;
			}
		}
		
	}
	
	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}

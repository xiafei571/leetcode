package id;

public class FindPeakElement162Min {
	
	/*
	 * LC162 Find Peak Element 变种 给一个数组, 返回任意一个 local minimum，也就是任意一个谷值
	 */
	public static void main(String[] args) {
		System.out.println(findPeakElement(new int[] {8,5,3,6,1,4,7}));
		System.out.println(findPeakElement(new int[] {1,2,1,3,5,6,4}));
	}
	
	public static int findPeakElement(int[] nums) {//直接上logn
		int left = 0;
		int right = nums.length;
		
		while(left < right) {
			int mid = (left + right) / 2;
			//8, 5 ,3
			if(nums[mid + 1] < nums[mid]) {
				left = mid + 1;
			}else {
				//3, 5 ,8
				right = mid;
			}
		}
		
		return left;
	}
}

package indeed;

public class FindPeakElement162 {
	
	public static void main(String[] args) {
		System.out.println(findPeakElement2(new int[] {1,2,3,1}));
		System.out.println(findPeakElement2(new int[] {1,2,1,3,5,6,4}));
	}
	
	public static int findPeakElement2(int[] nums) {//O(LogN)
		int left = 0;
		int right = nums.length - 1;
		while(left < right) {
			int mid = (left + right) / 2;
			if(nums[mid] > nums[mid + 1]) { // 1, 2, 5, 3, 4
				right = mid;
			}else{ // 1, 2, 3, 5, 4
                left = mid + 1;
            }
		}
		return left;
	}
	
	public static int findPeakElement(int[] nums) {//O(N)
        for(int i = 0; i < nums.length; i++){
            int left = Integer.MIN_VALUE;
            int right = Integer.MIN_VALUE;
            int mid = nums[i];
            if(i-1 >= 0){
                left = nums[i-1];
            }
            if(i + 1 < nums.length){
                right = nums[i+1];
            }

            if(right < mid && mid > left){
                return i;
            }
        }
        return 0;
    }
}

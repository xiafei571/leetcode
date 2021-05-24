package indeed;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges228 {

	/**
	 * 输入：nums = [0,2,3,4,6,8,9] 输出：["0","2->4","6","8->9"]
	 * 
	 * @param nums
	 * @return
	 */
	public static List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<String>();
		
		int left = 0;
		int right = 1;
		while(left < nums.length) {
			while(right <= nums.length) {
				if(right < nums.length && nums[right] == nums[right-1] + 1) {
					right++;
				}else {
					String range = "";
					if(right - left > 1) {
						range = nums[left]+"->"+nums[right-1];
					}else {
						range += nums[left];
					}
					result.add(range);
					left = right;
					right++;
				}
			}
		}
		
		
		return result;
	}

	public static void main(String[] args) {
		List<String> result = summaryRanges(new int[]{0,2,3,4,6,8,9});
		for(String s : result) {
			System.out.println(s);
		}
	}

}

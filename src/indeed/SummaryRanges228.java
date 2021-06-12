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
	/*
	 * Follow up1: 如果输⼊有duplicate numbers，怎么办?
	 * 用Set 或者 老方法遍历的时候注意一下+1和相等的情况，最好判断一下left == right不
	 * Follow up2: 没有排序呢?
	 * 用Map存，遍历的时候， 先判断map内存的值>0， 然后num -- ,++ 把左右搜索个遍
	 */

}

package sn;

import java.util.PriorityQueue;

public class FindKthLargest {
	public static void main(String[] args) {
		int[] nums = {3,4,1,2,6};
		
		System.out.println(findKthLargest(nums, 3));
		System.out.println(findKthLargest2(nums, 3));
	}
	
	public static int findKthLargest(int[] nums, int k) {//O(nlogk)
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		for(int num : nums) {
			minHeap.offer(num);
			
			if(minHeap.size() > k) {
				minHeap.poll();
			}
		}
		
		return minHeap.peek();
	}
	
	public static int findKthLargest2(int[] nums, int k) {
		return quickSelect(nums, 0, nums.length-1, k-1);
	}
	
	private static int quickSelect(int[] nums, int left, int right, int k) {
		int p = pos(nums, left, right);
		
		if(p == k) {
			return nums[p];
		}else if(p > k) {
			return quickSelect(nums, left, p-1, k);
		}else {
			return quickSelect(nums, p+1, right, k);
		}
	}
	
	private static int pos(int[] nums, int left, int right) {
		int p = nums[right];
		int i = left;
		for(int j = left; j < right; j++) {
			if(nums[j] > p) {
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

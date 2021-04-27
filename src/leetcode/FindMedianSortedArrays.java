package leetcode;

public class FindMedianSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		// odd 1 3 5 7 ...
		// even 2 4 6 8 ...
		int[] nums3 = new int[nums1.length + nums2.length];
		int idx1 = 0;
		int idx2 = 0;

		boolean odd = nums3.length % 2 != 0;

		for (int i = 0; i < nums3.length; i++) {
			if (nums2.length == 0 || idx2 >= nums2.length || (idx1 < nums1.length && nums1[idx1] < nums2[idx2])) {
				nums3[i] = nums1[idx1];
				idx1++;
			} else if (nums1.length == 0 || idx1 >= nums1.length
					|| (idx2 < nums2.length && nums1[idx1] >= nums2[idx2])) {
				nums3[i] = nums2[idx2];
				idx2++;
			}

			if (i == nums3.length / 2) {// 7/2=3(3), 10/2 = 5(4,5)
				if (odd) {
					return (double) nums3[i];
				} else {
					return (double) (nums3[i - 1] + nums3[i]) / 2;
				}
			}
		}

		return 0;

	}
}

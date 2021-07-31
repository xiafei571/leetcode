package leetcode;

public class FindMedianSortedArrays {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
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

	public static void main(String[] args) {
		System.out.println(findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 }));
		System.out.println(findMedianSortedArrays2(new int[] { 1, 2 }, new int[] { 3, 4 }));
	}

	public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
		if ((nums1.length + nums2.length) % 2 == 0) {
			return 0.5 * (findKth(nums1, 0, nums2, 0, (nums1.length + nums2.length + 1) / 2)
					+ findKth(nums1, 0, nums2, 0, (nums1.length + nums2.length + 2) / 2));
		} else {
			return findKth(nums1, 0, nums2, 0, (nums1.length + nums2.length + 2) / 2);
		}
	}

	private static double findKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
		int len1 = nums1.length - start1;
		int len2 = nums2.length - start2;

		if (len1 > len2) {
			return findKth(nums2, start2, nums1, start1, k);
		}

		if (len1 == 0) {
			return nums2[start2 + k - 1];
		}

		if (k == 1) {
			return Math.min(nums1[start1], nums2[start2]);
		}

		int i = start1 + Math.min(len1, k / 2) - 1;
		int j = start2 + Math.min(len2, k / 2) - 1;

		if (nums1[i] < nums2[j]) {
			return findKth(nums1, i + 1, nums2, start2, k - Math.min(len1, k / 2));
		} else {
			return findKth(nums1, start1, nums2, j + 1, k - Math.min(len2, k / 2));
		}
	}
}

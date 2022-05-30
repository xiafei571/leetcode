package bytedance;

public class MergeSortedArray88 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int p = nums1.length - 1;
		int p1 = m - 1;
		int p2 = n - 1;

		for (; p >= 0; p--) {

			if (p2 < 0) {
				break;
			}

			if (p1 >= 0 && nums1[p1] > nums2[p2]) {
				nums1[p] = nums1[p1--];
			} else {
				nums1[p] = nums2[p2--];
			}

		}
	}
}

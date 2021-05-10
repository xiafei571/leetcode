package leetcode;

public class Merge88 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		if (m == 0) {
			for (int i = 0; i < n; i++) {
				nums1[i] = nums2[i];
			}
			return;
		}

		if (n == 0) {
			return;
		}

		for (int i = m + n - 1; i >= 0; i--) {
			if (m > 0 && n > 0) {
				if (nums1[m - 1] > nums2[n - 1]) {
					nums1[i] = nums1[m - 1];
					m--;
				} else {
					nums1[i] = nums2[n - 1];
					n--;
				}
			} else if (m == 0 && n > 0) {
				nums1[i] = nums2[n - 1];
				n--;
			} else if (m > 0 && n == 0) {
				nums1[i] = nums1[m - 1];
				m--;
			}
		}
	}
}

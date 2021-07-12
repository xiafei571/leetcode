package id;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersection350 {
	public static int[] intersection(int[] nums1, int[] nums2) {

		List<Integer> res = new ArrayList<Integer>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int p1 = 0;
		int p2 = 0;

		while (p1 < nums1.length && p2 < nums2.length) {
			if (nums1[p1] == nums2[p2]) {
				res.add(nums1[p1]);
				p1++;
				p2++;
			} else if (nums1[p1] > nums2[p2]) {
				p2++;
			} else {
				p1++;
			}
		}

		int[] result = new int[res.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = res.get(i);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] res = intersection(new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 });
		for (int i : res) {
			System.out.print(i + " ");
		}
	}
}

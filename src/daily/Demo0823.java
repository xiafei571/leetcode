package daily;

import java.util.Set;

import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;

/**
 * 	找字符串子串
 * 	返回两个数组交集，不能出现重复
 * @author user
 *
 */
public class Demo0823 {

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 2, 3, 1 };
		int[] nums2 = { 2, 3, 4, 5 };
		// 2,3
		int[] nums3 = mixArray(nums1, nums2);
		// 2,3
		int[] nums4 = mixArray(nums1, nums3);
		// print
		printArray(nums3);
		printArray(nums4);

		String s1 = "abcdc";
		String s2 = "cbbd";
		String s3 = "babad";
		String s4 = "aba";

		System.out.println(findChildStr(s1));
		System.out.println(findChildStr(s2));
		System.out.println(findChildStr(s3));
		System.out.println(findChildStr(s4));
		
		/*
		 * Examples: 
 			"hamburger".substring(4, 8) returns "urge"
 			"smiles".substring(1, 5) returns "mile"
		 */
	}

	private static void printArray(int[] nums) {
		for (int i : nums) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static int[] mixArray(int[] nums1, int[] nums2) {
		// 返回两个数组交集，不能出现重复
		//int[] nums1 = { 1, 2, 2, 3, 1 };
		//int[] nums2 = { 2, 3, 4, 5 };
		//Set集合内容不重复，List集合内容可以重复
		Set<Integer> set = Sets.newHashSet();

		for (int num : nums1) {
			if (contains(num, nums2)) {
				set.add(num);
			}
		}

		return Ints.toArray(set);
	}

	private static boolean contains(int num, int[] nums) {
		for (int i : nums) {
			if (num == i)
				return true;
		}
		return false;
	}

	public static String findChildStr(String str) {
		// 从左看 从右看 (正着读，倒着读)都一样的子串，只返回一个最大的即可 ，这个子串至少有俩字母
		// abcdc -> cdc
		// cbbd -> bb
		// babad-> bab / aba 都可以，返回一个即可
		// aba => aba
		int len = str.length();
		if (len < 2) {
			return null;
		}

		for (int i = 0; i < len / 2; i++) {
			if (str.charAt(i) != str.charAt(len - i - 1)) {// 根据字符串的下标
				// 不一样的
				String left = findChildStr(str.substring(0, len - 1));
				String right = findChildStr(str.substring(1, len));

				if (null != left && null != right) {
					return left.length() > right.length() ? left : right;
				} else {
					return null != left ? left : right;
				}
			}
		}

		return str;
	}

}

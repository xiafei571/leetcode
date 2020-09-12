package daily;

import java.util.ArrayList;
import java.util.List;

/**
 * 	杨辉三角
 * 	找到数组的插入位置或target在数组中的下标
 * 	计算单词长度
 * @author user
 *
 */
public class Demo0822 {

	public static void main(String[] args) {

		printYHSJ(5);

		List<Integer> list = countWord(new String("Hello World FINE THANK YOU AND YOU"));
		for (Integer i : list) {
			System.out.println(i);
		}
//		int[] nums_1 = { 0, 1, 3, 4, 6, 9 };
//		System.out.println(searchInsert_zmx(nums_1, 4));
//		System.out.println(searchInsert_zmx(nums_1, 9));
//		System.out.println(searchInsert_zmx(nums_1, 5));
//		System.out.println(searchInsert_zmx(nums_1, 1));
//		System.out.println(searchInsert_zmx(nums_1, 0));
//
//		System.out.println(searchInsert_wx(nums_1, 4));
//		System.out.println(searchInsert_wx(nums_1, 9));
//		System.out.println(searchInsert_wx(nums_1, 5));
//		System.out.println(searchInsert_wx(nums_1, 1));
//		System.out.println(searchInsert_wx(nums_1, 0));
//
//		System.out.println("------------------------------");
//
//		int[] nums_2 = { 1, 1, 1, 3, 3, 4, 6, 9 };
//
//		int len_nums_2 = removeDuplicates(nums_2);
//		System.out.println("len:" + len_nums_2);
//		for (int i = 0; i < len_nums_2; i++) {
//			System.out.print(nums_2[i] + " ");
//		}
//		
//		System.out.println();
//		int aaa = 100;
//		System.out.printf("%d", aaa);

	}

	private static int searchInsert_zmx(int[] nums, int target) {
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				index = i;
			}

			if (i == nums.length - 1) {
				for (int j = i; j > 0; j--) {
					if (nums[j - 1] < target && nums[j] > target) {
						index = j;
					}
				}
			}
		}

		return index;
	}

	private static int searchInsert_wx(int[] nums, int target) {
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (target <= nums[i]) {
				index = i;
				break;
			} else {
				index = nums.length;
			}
		}

		return index;
	}

	private static int searchInsert(int[] nums, int target) {
		// 给定一个有序数组 nums [1, 3, 4, 6, 9]
		// case1 输入一个target 4
		// 返回target的下标 2

		// case2 输入一个target 9
		// 返回target的下标 4

		// case3 输入一个target 5
		// 返回target的下标 3

		return 0;
	}

	private static int removeDuplicates(int[] nums) {
		// 给定一个数组 nums [1, 1, 1, 3, 3, 4, 6, 9]
		// 不可以使用额外空间，并且原数组前5位改为 [1,3,4,6,9...]
		// 返回新非重复数组的长度 5
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[i]) {
				nums[i + 1] = nums[j];
				i++;
			}
		}

		return i + 1;
	}

	/*
	 * 3 * *** *****
	 * 
	 */
	private static void printYHSJ(int high) {// high >=3
		/*
		 * 5 1 1 0 0 0 0 1 1 1 1 0 0 0 1 2 1 1 2 1 0 0 1 3 3 1 1 3 3 1 0 1 4 6 4 1 1 4 6
		 * 4 1 每个数都等于自己左上方的数+自己上方的数
		 */
		int[][] array = new int[high][high];
		array[0][0] = 1;
		for (int i = 1; i < array.length; i++) {
			array[i][0] = 1;
			for (int j = 1; j < array[i].length; j++) {
				array[i][j] = array[i - 1][j - 1] + array[i - 1][j];
			}

		}
//		print2D(array);
		printTree(array);

	}

	private static void printTree(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			// space
			for (int space = 0; space < array.length - i; space++) {
				// 5 -> 1
				System.out.print(" ");
			}

			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] != 0)
					System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void print2D(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static List<Integer> countWord(String str) {
		List<Integer> list = new ArrayList<Integer>();
		// String str = "Hello World FINE THANK YOU AND YOU"
		// 返回 单词长度[5,5,4,5,3,3,3]
		String[] str_list = str.split(" ");
		for (String s : str_list) {
			list.add(s.length());
		}
		return list;
	}
}

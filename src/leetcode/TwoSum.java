package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.1 Created by xiafei on 16/10/28. Given an array of integers, return indices of
 * the two numbers such that they add up to a specific target. You may assume
 * that each input would have exactly one solution. Example: Given nums = [2, 7,
 * 11, 15], target = 9, Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] temp = nums.clone();
        // Arrays.sort(temp);
        // 冒泡排一下
        int x = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = i; j < temp.length; j++) {
                if (temp[i] > temp[j]) {
                    x = temp[i];
                    temp[i] = temp[j];
                    temp[j] = x;
                }
            }
        }
        int left = 0;
        int right = nums.length - 1;
        int sum = 0;
        List<Integer> indexList = new ArrayList<>();

        while (left < right) {
            sum = temp[left] + temp[right];
            if (sum == target) {
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] == temp[left]) {
                        indexList.add(i);
                    } else if (nums[i] == temp[right]) {
                        indexList.add(i);
                    }

                    if (indexList.size() == 2)
                        break;
                }
                // 注意这里break 要不然死循环
                break;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        int[] result = new int[2];
        result[0] = indexList.get(0);
        result[1] = indexList.get(1);

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(String.format("[%s, %s]", result[0], result[1]));
    }
}

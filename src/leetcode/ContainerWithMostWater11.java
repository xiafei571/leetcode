package leetcode;

public class ContainerWithMostWater11 {
	public int maxArea(int[] height) {
		int max = 0;
		int left = 0;
		int right = height.length - 1;
		while (left < right) {
			max = Math.max(max, getArea(left, right, height));
			if (height[left] <= height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return max;
	}

	private static int getArea(int left, int right, int[] height) {
		if (height[left] < height[right]) {
			return height[left] * (right - left);
		} else {
			return height[right] * (right - left);
		}
	}
}

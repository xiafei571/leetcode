package am;

public class MaxArea11 {
	public int maxArea(int[] height) {
		int max = 0;
		if (height.length < 2) {
			return max;
		}

		int left = 0;
		int right = height.length - 1;

		while (left < right) {
			int width = right - left;
			max = Math.max(max, Math.min(height[left], height[right]) * width);

			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}

		return max;
	}
}

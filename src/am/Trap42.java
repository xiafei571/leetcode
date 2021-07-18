package am;

public class Trap42 {
	public int trap(int[] height) { // height = [0,1,0,2,1,0,1,3,2,1,2,1] output = 6
		if (height.length < 2) {
			return 0;
		}

		int[] left = new int[height.length];
		int[] right = new int[height.length];

		int l = 0;
		for (int i = 0; i < height.length; i++) {// fill left
			l = Math.max(l, height[i]);
			left[i] = l;
		}

		int r = 0;
		for (int j = height.length - 1; j >= 0; j--) {// fill right
			r = Math.max(r, height[j]);
			right[j] = r;
		}

		int result = 0;
		for (int k = 0; k < height.length; k++) {
			result += Math.min(left[k], right[k]) - height[k];
		}

		return result;
	}
}

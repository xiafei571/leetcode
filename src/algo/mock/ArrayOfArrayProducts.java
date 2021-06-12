package algo.mock;

public class ArrayOfArrayProducts {
	static int[] arrayOfArrayProducts(int[] arr) {
		// your code goes here
		if (arr.length <= 1) {
			return new int[] {};
		}

		int i = 0;
		int[] left = new int[arr.length];
		int[] right = new int[arr.length];
		int[] result = new int[arr.length];
		while (i < arr.length) {
			int j = arr.length - i - 1;
			if (i == 0) {
				left[i] = 1;
				right[j] = 1;
				i++;
				continue;
			}

			left[i] = left[i - 1] * arr[i - 1];
			right[j] = right[j + 1] * arr[j + 1];
			i++;
		}

		for (int k = 0; k < arr.length; k++) {
			result[k] = left[k] * right[k];
		}

		return result;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 10 };
		int[] res = arrayOfArrayProducts(arr);
		for (int i : res) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}

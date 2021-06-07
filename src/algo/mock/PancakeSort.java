package algo.mock;

public class PancakeSort {
	static int[] pancakeSort(int[] arr) {// Time:O(n^2)
		// your code goes here
		int n = arr.length;
		while (n >= 0) {
			int maxIdx = findMaxIdx(arr, n);
			if (maxIdx != n - 1) {
				// [1,5,4,3,2]
				flip(arr, maxIdx + 1);
				// [5,1,4,3,2]
				flip(arr, n);
			}
			n--;
		}
		return arr;
	}

	static void flip(int[] arr, int k) {// O(N)
		int left = 0;
		while (left < k) {
			int temp = arr[left];
			arr[left] = arr[k - 1];
			arr[k - 1] = temp;

			left++;
			k--;
		}
	}

	static int findMaxIdx(int[] arr, int end) {// O(N)
		int max = arr[0];
		int idx = 0;
		for (int i = 0; i < end; i++) {
			if (arr[i] > max) {
				max = arr[i];
				idx = i;
			}
		}
		return idx;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 5, 4, 3, 2 };
		int[] result = pancakeSort(arr);
		for (int i : result) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}

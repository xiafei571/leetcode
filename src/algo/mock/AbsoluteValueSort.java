package algo.mock;

public class AbsoluteValueSort {
	static int[] absSort(int[] arr) {
		// your code goes here
		sortMethod1(arr);
		return arr;
	}

	// If two numbers have the same absolute value, sort them according to sign,
	static int[] sortMethod1(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (Math.abs(arr[i]) == Math.abs(arr[j])) {
					if (arr[i] > arr[j]) {
						swap(arr, i, j);
					}
				} else if (Math.abs(arr[i]) > Math.abs(arr[j])) {
					swap(arr, i, j);
				}
			}
		}
		
		return arr;
	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {

		int[] arr = { 2, -7, -2, -2, 0 };
		int[] res = absSort(arr);
		for (int i : res) {
			System.out.print(i + " ");
		}
	}
}

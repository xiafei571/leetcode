package leetcode;

public class PeakIndexInMountainArray852 {
	public int peakIndexInMountainArray(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int middle = (left + right) / 2;
			if (arr[middle] < arr[middle + 1]) {
				// up
				left = middle + 1;
			} else if (arr[middle] < arr[middle - 1]) {
				//down
				right = middle - 1;
			} else {
				return middle;
			}
		}

		return -1;
	}
}

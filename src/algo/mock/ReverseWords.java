package algo.mock;

import java.util.ArrayList;
import java.util.List;

public class ReverseWords {
	static char[] reverseWords(char[] arr) {
		// your code goes here
		List<Integer[]> list = new ArrayList<Integer[]>();
		int i = 0;
		int j = 1;
		while (j < arr.length + 1) {
			if (j == arr.length) {
				list.add(new Integer[] { i, j, 0 });
				break;
			} else if (arr[j] == ' ') {
				int space = 0;
				while (j < arr.length && arr[j] == ' ') {
					j++;
					space++;
				}
				list.add(new Integer[] { i, j, space });
				i = j;
			} else {
				j++;
			}

		}

		char[] result = new char[arr.length];
		int resIdx = 0;
		for (int k = list.size() - 1; k >= 0; k--) {
			Integer[] range = list.get(k);

			int start = range[0];
			int end = range[1];
			int space = range[2];

			for (int s = 0; s < space; s++) {
				result[resIdx] = ' ';
				resIdx++;
			}

			while (start < end - space || start == 0) {
				result[resIdx] = arr[start];
				start++;
				resIdx++;
			}
		}

		return result;
	}

	public static void main(String[] args) {

		char[] arr = new char[] { 'p', 'e', 'r', 'f', 'e', 'c', 't', ' ', ' ', 'm', 'a', 'k', 'e', 's', ' ', 'p', 'r',
				'a', 'c', 't', 'i', 'c', 'e' };
		char[] output = reverseWords(arr);
		for (char c : output) {
			System.out.print(c + " ");
		}
		
		char[] arr1 = new char[] { 'a',' ', ' ','b' };
		char[] output1 = reverseWords(arr1);
		for (char c : output1) {
			System.out.print(c + " ");
		}
		
		char[] arr2 = new char[]{'p','e','r','f','e','c','t',' ','m','a','k','e','s',' ','p','r','a','c','t','i','c','e'};
		char[] output2 = reverseWords(arr2);
		for (char c : output2) {
			System.out.print(c + " ");
		}
	}
}

package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class Partition131 {

	public static void main(String[] args) {
		String s1 = "aab";
		System.out.println("intput:" + s1);
		List<List<String>> result1 = partition(s1);
		printResult(result1);

		String s2 = "a";
		System.out.println("intput:" + s2);
		List<List<String>> result2 = partition(s2);
		printResult(result2);
		
		String s3 = "cdd";
		System.out.println("intput:" + s3);
		List<List<String>> result3 = partition(s3);
		printResult(result3);
	}

	private static void printResult(List<List<String>> result) {
		for (List<String> list : result) {
			for (String str : list) {
				System.out.print(str + " ");
			}
			System.out.println();
		}
	}

	public static List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<List<String>>();

		List<String> current = new ArrayList<String>();
		dfs(s, 0, result, current);

		return result;
	}

	private static void dfs(String s, int start, List<List<String>> result, List<String> currentArray) {
		if (start >= s.length()) {
			result.add(new ArrayList<String>(currentArray));
			return;
		}

		for (int j = start + 1; j < s.length() + 1; j++) {
			String subStr = s.substring(start, j);
			if (isPartition(subStr)) {
				currentArray.add(subStr);
				dfs(s, j, result, currentArray);
				currentArray.remove(currentArray.size() - 1);
			}
		}
	}

	private static boolean isPartition(String s) {
		if (s.length() <= 1) {
			return true;
		}

		int left = 0;
		int right = s.length() - 1;

		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}

			left++;
			right--;
		}
		return true;
	}
}

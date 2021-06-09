package algo.mock;

import java.util.HashMap;
import java.util.Map;

public class GetShortestUniqueSubstring {
	public static void main(String[] args) {
		char[] arr = new char[] { 'x', 'y', 'z' };
		System.out.println(getShortestUniqueSubstring(arr, "xyyzyzyx"));
		System.out.println(getShortestUniqueSubstring(arr, "xyyz"));
		System.out.println(getShortestUniqueSubstring(arr, "xzyzyx"));
	}

	private static String getShortestUniqueSubstring(char[] arr, String str) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (char c : str.toCharArray()) {
			map.put(String.valueOf(c), map.getOrDefault(String.valueOf(c), 0) + 1);
		}

		if (map.keySet().size() < arr.length) {
			return null;
		}

		int left = 0;
		int right = str.length() - 1;

		while (left + arr.length <= right) {
			int left_cnt = map.get(String.valueOf(str.charAt(left)));
			int right_cnt = map.get(String.valueOf(str.charAt(right)));
			if (left_cnt > 1) {
				left_cnt--;
				map.put(String.valueOf(str.charAt(left)), left_cnt);
				left++;
			} else if (right_cnt > 1) {
				right_cnt--;
				map.put(String.valueOf(str.charAt(right)), right_cnt);
				right--;
			} else {
				break;
			}

		}

		return str.substring(left, right + 1);

	}
}

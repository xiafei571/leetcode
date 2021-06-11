package algo.mock;

import java.util.HashMap;
import java.util.Map;

public class GetShortestUniqueSubstring {
	public static void main(String[] args) {
		char[] arr = new char[] { 'x', 'y', 'z' };
		System.out.println(getShortestUniqueSubstring2(arr, "xyyzyzyx"));
		System.out.println(getShortestUniqueSubstring2(arr, "xyyz"));
		System.out.println(getShortestUniqueSubstring2(arr, "xzyzyx"));
	}

	private static String getShortestUniqueSubstring2(char[] arr, String str) {
		String result = "";
		int uniqueCnt = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : arr) {
			map.put(c, 0);
		}

		int left = 0;
		for (int right = 0; right < str.length(); right++) {
			char rightChar = str.charAt(right);
			if (!map.containsKey(rightChar)) {
				continue;
			}

			int count = map.get(rightChar);
			if(count == 0) {
				uniqueCnt++;
			}
			map.put(rightChar, count + 1);

			while (uniqueCnt == arr.length) {
				int tempLength = right - left + 1;
				if(tempLength == arr.length) {
					return str.substring(left, right+1);
				}
				
				if(result == "" || result.length() > tempLength) {
					//update result
					result = str.substring(left, right+1);
				}
				
				char leftChar = str.charAt(left);
				if(map.containsKey(leftChar)){
					map.put(leftChar, map.get(leftChar) - 1);
					left++;
					if(map.get(leftChar) == 0) {
						uniqueCnt--;
					}
				}
				
			}
		}
		return result;
	}

	/**
	 * @deprecated
	 * @param arr
	 * @param str
	 * @return
	 */
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

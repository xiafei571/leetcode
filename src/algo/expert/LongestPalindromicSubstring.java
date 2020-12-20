package algo.expert;

public class LongestPalindromicSubstring {
	public static String longestPalindromicSubstring(String str) {
		// Write your code here.
		if (str.length() == 1) {
			return str;
		}
		String longest = "";
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				String substring = str.substring(i, j);
				if (substring.length() > longest.length() && isPalindrom(substring)) {
					longest = substring;
				}
			}
		}
		return longest;
	}

	private static boolean isPalindrom(String str) {
		int left = 0;
		int right = str.length() - 1;
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}

package algo.expert;

public class IsPalindrome {
	public static boolean isPalindrome(String str) {
		String reversedStr = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			reversedStr += str.charAt(i);
		}
		return str.equals(reversedStr);
	}

	public static boolean isPalindrome_2(String str) {
		int leftIdx = 0;
		int rightIdx = str.length() - 1;
		while (leftIdx < rightIdx) {
			if (str.charAt(leftIdx) != str.charAt(rightIdx)) {
				return false;
			}
			leftIdx++;
			rightIdx--;
		}
		return true;
	}
}

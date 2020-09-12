package leetcode;

public class LongestPalindrome {
	public static void main(String[] args) {
//		System.out.println(longestPalindrome("cbbd"));
		System.out.println(longestPalindrome("babad"));
	}

	public static String longestPalindrome(String s) {
		if (isPalindrome(s)) {
			return s;
		}

		int lens = s.length() - 1;
		while (lens > 0) {
			for (int i = 0; i + lens <= s.length(); i++) {
				String lst = s.substring(i, i + lens);
				if (isPalindrome(lst)) {
					return lst;
				}
			}
			lens--;
		}
		return null;
	}

	private static boolean isPalindrome(String s) {
		int i = 0; 
//		for (int i = 0; i < s.length() / 2; i++) {
//			for (int j = s.length()-1; j >= s.length() / 2; j--) {
////				if(i == j)
////					return true;
//				
//				if (s.charAt(i) != s.charAt(j))
//					return false;
//
//			}
//		}
		return true;
	}
}

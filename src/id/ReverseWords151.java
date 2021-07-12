package id;

import java.util.Stack;

public class ReverseWords151 {
	public static String reverseWords3(String s) {

		StringBuilder sb = new StringBuilder();

		char[] chars = s.toCharArray();
		reverse(chars, 0, chars.length - 1);//O(N)

		// a hello world -> dlrow olleh a
		int left = 0;
		int right = left;
		while (left < chars.length) {//O(N)?
			if (chars[left] == ' ') {
				left++;
				if (right < left) {
					right = left;
				}
				continue;
			} else {
				right++;
			}

			if (right == chars.length || chars[right] == ' ') {
				sb.append(reverse(chars, left, right - 1)).append(" ");
				left = right + 1;
				right = left;
			}
		}

		return sb.substring(0, sb.length() - 1);
	}

	private static String reverse(char[] chars, int left, int right) {
		if (left == right) {
			return "";
		}
		int i = left;
		int j = right + 1;
		while (left < right) {
			char temp = chars[left];
			chars[left] = chars[right];
			chars[right] = temp;
			left++;
			right--;
		}
		StringBuilder sb = new StringBuilder();
		for (; i < j; i++) {
			sb.append(chars[i]);
		}

		return sb.toString();
	}

	public static String reverseWords2(String s) {
		String res = new String();
		Stack<Character> stack = new Stack<Character>();

		int i = 0;
		while (i < s.length()) {
			if (s.charAt(i) == ' ' && stack.size() > 0) {
				while (stack.size() > 0) {
					res = stack.pop() + res;
				}
				res = " " + res;

			} else if (s.charAt(i) != ' ') {
				stack.push(s.charAt(i));
			}
			i++;
		}

		while (stack.size() > 0) {
			res = stack.pop() + res;
		}

		return res.trim();
	}

	public static String reverseWords1(String s) {// 1. Brute force
		s = s.trim();
		String[] strs = s.split("\\s+");
		StringBuilder sb = new StringBuilder();
		for (int i = strs.length - 1; i >= 0; i--) {
			if (strs[i].equals("") || strs[i].equals(" ")) {
				continue;
			}
			sb.append(strs[i]);
			if (i != 0) {
				sb.append(" ");
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(reverseWords3("the sky is blue"));
		System.out.println(reverseWords3("  hello world  "));
	}
}

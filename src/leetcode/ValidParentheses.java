package leetcode;

import java.util.Stack;

public class ValidParentheses {

	/*
	 * 20. Given a string s containing just the characters '(', ')', '{', '}', '[' and
	 * ']', determine if the input string is valid.
	 * 
	 * An input string is valid if:
	 * 
	 * Open brackets must be closed by the same type of brackets. Open brackets must
	 * be closed in the correct order.
	 */

	static String[] list = { "(", ")", "{", "}", "[", "]" };

	private static int getIndex(String s) {
		for (int i = 0; i < list.length; i++) {
			if (list[i].equals(s)) {
				return i;
			}
		}
		return -1;
	}

	private static boolean isPair(String s) {
		if (s.length() != 2)
			return false;

		int left = getIndex(s.substring(0, 1));
		if (left % 2 == 0) {
			int right = getIndex(s.substring(1, 2));
			if (right == left + 1) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	public static boolean isValid(String s) {
		String[] str_list = s.split("");

		if (isPair(s)) {
			return true;
		} else if (str_list.length > 2) {
			if (getIndex(str_list[0]) == getIndex(str_list[1]) - 1) {
				return isValid(s.substring(2, str_list.length));
			}

			if (getIndex(str_list[0]) == getIndex(str_list[str_list.length - 1]) - 1) {
				return isValid(s.substring(1, str_list.length - 1));
			}
		}

		return false;
	}

	public static void main(String[] args) {
		System.out.println(isValid2("(([]){})"));
		System.out.println(isValid("([)]"));
		System.out.println(isValid("([)]"));
		System.out.println(isValid("{[]}"));
	}

	private static boolean isValid2(String s) {
		Stack<String> stack = new Stack<String>();
		String[] str_list = s.split("");

		for (int i = 0; i < str_list.length; i++) {
			if (stack.empty() || getIndex(str_list[i]) % 2 == 0) {
				stack.push(str_list[i]);
			} else {
				if (getIndex(str_list[i]) == getIndex(stack.peek()) + 1) {
					stack.pop();
				} else {
					stack.push(str_list[i]);
				}
			}
		}

		if (stack.empty()) {
			return true;
		} else {
			return false;
		}
	}

}

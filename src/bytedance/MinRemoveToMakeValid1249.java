package bytedance;

import java.util.Stack;

public class MinRemoveToMakeValid1249 {
	public String minRemoveToMakeValid(String s) {
		char[] chars = s.toCharArray();
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '(') {
				stack.add(i);
			} else if (chars[i] == ')') {
				if (stack.isEmpty()) {
					chars[i] = ' ';
				} else {
					stack.pop();
				}
			}
		}

		while (!stack.isEmpty()) {
			chars[stack.pop()] = ' ';
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] != ' ') {
				sb.append(chars[i]);
			}
		}

		return sb.toString();

	}
}

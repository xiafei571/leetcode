package am;

import java.util.Stack;

public class BasicCalculator2 {
	public int calculate(String s) {
		int res = 0;
		s = s.replaceAll(" ", "");
		Stack<Integer> stack = new Stack<Integer>();
		int idx = 0;
		int cur = 0;
		int operation = '+';
		while (idx < s.length()) {
			char ch = s.charAt(idx);
			if (Character.isDigit(ch)) {
				cur = cur * 10 + ch - '0';
			}

			if (!Character.isDigit(ch) || idx == s.length() - 1) {
				if (operation == '+') {
					stack.push(cur);
				} else if (operation == '-') {
					stack.push(0 - cur);
				} else {

					if (operation == '*') {
						stack.push(stack.pop() * cur);
					} else if (operation == '/') {
						stack.push(stack.pop() / cur);
					}

				}
				cur = 0;
				operation = ch;
			}
			idx++;
		}

		while (!stack.isEmpty()) {
			res += stack.pop();
		}

		return res;
	}
}

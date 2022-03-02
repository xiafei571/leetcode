package am;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IsBalanced {
	public static String isBalanced(String s) {
		// Write your code here
		Map<Character, Character> left = new HashMap<>();
		Map<Character, Character> right = new HashMap<>();

		left.put('[', ']');
		left.put('{', '}');
		left.put('(', ')');

		right.put(']', '[');
		right.put('}', '{');
		right.put(')', '(');

		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (left.containsKey(ch)) {
				stack.add(ch);
			} else if (right.containsKey(ch)) {
				if (stack.size() == 0) {
					return "NO";
				}

				if (right.get(ch) == stack.peek()) {
					stack.pop();
				} else {
					return "NO";
				}
			} else {
				return "NO";
			}
		}
		return stack.size() == 0 ? "YES" : "NO";
	}
}

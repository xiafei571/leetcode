package am;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IsValid20 {
	public boolean isValid(String s) {
		if (s == null || s.length() < 2)
			return false;

		Map<Character, Character> brackets = new HashMap<Character, Character>();
		brackets.put('(', ')');
		brackets.put('[', ']');
		brackets.put('{', '}');

		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (brackets.containsKey(s.charAt(i))) {
				stack.add(s.charAt(i));
			} else {
				if (stack.size() == 0) {
					return false;
				}

				Character head = stack.pop();
				if (s.charAt(i) != brackets.get(head)) {
					return false;
				}
			}
		}

		return stack.size() == 0;
	}
}

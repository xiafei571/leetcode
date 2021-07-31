package am;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MinRemoveToMakeValid1249 {

	public String minRemoveToMakeValid(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		Set<Integer> delete = new HashSet<Integer>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(') {
				stack.add(i);
			} else if (ch == ')') {
				if (stack.isEmpty()) {
					delete.add(i);
				} else {
					stack.pop();
				}
			}
		}

		while (!stack.isEmpty()) {
			delete.add(stack.pop());
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (!delete.contains(i)) {
				sb.append(s.charAt(i));
			}
		}

		return sb.toString();
	}
}

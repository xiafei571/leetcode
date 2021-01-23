package algo.expert;

import java.util.Stack;

public class BalancedBrackets {
	public static boolean balancedBrackets(String str) {
		// Write your code here.
		if (str == null || str.length() == 0)
			return false;

		Stack<Character> stack = new Stack<Character>();
		// %2 == 0 start, %2 == 1 end
		Character[] array = { '(', ')', '[', ']', '{', '}' };
		for (int i = 0; i < str.length(); i++) {
			int idx = getIndex(array, str.charAt(i));
			if (idx == -1) {
				continue;
			} else if (idx % 2 == 0) {
				stack.add(str.charAt(i));
			} else {
				if (stack.empty())
					return false;

				Character c = stack.pop();
				if (getIndex(array, c) + 1 == idx) {// matched
					continue;
				} else {
					return false;
				}
			}

		}
		return stack.empty();
	}

	private static int getIndex(Character[] array, Character target) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target) {
				return i;
			}
		}
		return -1;
	}
}

package am;

import java.util.Stack;

public class EvalRPN150 {
	public int evalRPN(String[] tokens) {
		Stack<Integer> nums = new Stack<Integer>();
		for (String token : tokens) {
			if (isInteger(token)) {
				nums.add(Integer.valueOf(token));
			} else {
				int num2 = nums.pop();
				int num1 = nums.pop();
				nums.add(cal(num1, num2, token));
			}
		}

		return nums.pop();
	}

	private static int cal(int num1, int num2, String op) {
		if (op.equals("+")) {
			return num1 + num2;
		} else if (op.equals("-")) {
			return num1 - num2;
		} else if (op.equals("*")) {
			return num1 * num2;
		} else {
			return num1 / num2;
		}
	}

	private static boolean isInteger(String str) {
		if (str == null || str.length() == 0) {
			return false;
		}

		for (int i = 0; i < str.length(); i++) {
			if (str.length() > 1 && i == 0 && str.charAt(i) == '-') {
				continue;
			}

			if (str.charAt(i) < '0' || str.charAt(i) > '9') {
				return false;
			}
		}

		return true;
	}
}

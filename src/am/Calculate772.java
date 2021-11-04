package am;

import java.util.Map;
import java.util.Stack;
import java.util.HashMap;

public class Calculate772 {

	public static void main(String[] args) {
		System.out.println(calculate("2*(5+5*2)/3+(6/2+8)"));
	}

	private static Map<Character, Integer> priority = new HashMap<Character, Integer>() {
		{
			put('+', 1);
			put('-', 1);
			put('*', 2);
			put('/', 2);
		}
	};

	static class OpsLevel {
		Character op;
		int level;

		public OpsLevel(Character op, int level) {
			this.op = op;
			this.level = level;
		}
	}

	public static int calculate(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		Stack<Integer> nums = new Stack<Integer>();
		Stack<OpsLevel> ops = new Stack<OpsLevel>();

		s = s.replace(" ", "");
		int idx = 0;
		int level = 0;

		while (idx < s.length()) {
			if (s.charAt(idx) == '(') {
				level++;
			} else if (s.charAt(idx) == ')') {
				level--;
			} else if (isNum(s.charAt(idx))) {
				String temp = String.valueOf(s.charAt(idx));
				while (idx + 1 < s.length() && isNum(s.charAt(idx + 1))) {
					idx++;
					temp += String.valueOf(s.charAt(idx));
				}

				nums.add(Integer.valueOf(temp));
			} else {
				if (s.charAt(idx) == '-' && (idx == 0 || s.charAt(idx - 1) == '(')) {
					nums.add(0);
				}
				// level and priori
				char op = s.charAt(idx);
				while (!ops.isEmpty()) {
					if (level == ops.peek().level && priority.get(op) <= priority.get(ops.peek().op)) {
						int num2 = nums.pop();
						int num1 = nums.pop();
						OpsLevel opsLevel = ops.pop();
						nums.add(eval(num1, num2, opsLevel.op));
					} else if (level < ops.peek().level) {
						int num2 = nums.pop();
						int num1 = nums.pop();
						OpsLevel opsLevel = ops.pop();
						nums.add(eval(num1, num2, opsLevel.op));
					} else {
						break;
					}
				}

				ops.add(new OpsLevel(s.charAt(idx), level));
			}

			idx++;
		}
		cal(nums, ops);
		return nums.pop();

	}

	private static void cal(Stack<Integer> nums, Stack<OpsLevel> ops) {
		while (!ops.isEmpty()) {
			int num2 = nums.pop();
			int num1 = nums.pop();
			OpsLevel opsLevel = ops.pop();
			nums.add(eval(num1, num2, opsLevel.op));
		}
	}

	private static boolean isNum(char ch) {
		return ch >= '0' && ch <= '9';
	}

	private static int eval(int num1, int num2, char op) {
		if (op == '+') {
			return num1 + num2;
		} else if (op == '-') {
			return num1 - num2;
		} else if (op == '*') {
			return num1 * num2;
		} else if (op == '/') {
			return num1 / num2;
		} else {// TODO
			return 0;
		}
	}
}

package am;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Caculate227 {

	private static Map<Character, Integer> map = new HashMap<Character, Integer>() {
		{
			put('-', 1);
			put('+', 1);
			put('*', 2);
			put('/', 2);
		}
	};

	public static int calculate(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		s = s.replace(" ", "");
		s = "0" + s;
		Stack<Integer> nums = new Stack<Integer>();
		Stack<Character> ops = new Stack<Character>();

		char[] chars = s.toCharArray();
		int idx = 0;
		while (idx < chars.length) {
			char ch = chars[idx];
			if (ch == ' ') {
				continue;
			}

			if (isNumber(ch)) {
				String temp = String.valueOf(ch);
				while (idx + 1 < chars.length && isNumber(chars[idx + 1])) {
					idx++;
					temp += String.valueOf(chars[idx]);
				}
				nums.add(Integer.valueOf(temp));
			} else {
				if (ops.isEmpty()) {
					ops.add(ch);
				} else {
					if (map.get(ch) > map.get(ops.peek())) {
						ops.add(ch);
					} else {
						int res = calculateHelper(nums, ops.pop());
						nums.add(res);
						ops.add(ch);
					}
				}
			}

			idx++;
		}

		while (!ops.isEmpty()) {
			int res = calculateHelper(nums, ops.pop());
			nums.add(res);
		}

		return nums.pop();

	}

	private static int calculateHelper(Stack<Integer> nums, char operator) {
		int num2 = nums.pop();
		int num1 = nums.pop();
		if (operator == '+') {
			return num1 + num2;
		} else if (operator == '-') {
			return num1 - num2;
		} else if (operator == '*') {
			return num1 * num2;
		} else {
			return num1 / num2;
		}
	}

	private static boolean isNumber(char ch) {
		return ch >= '0' && ch <= '9';
	}

	public static void main(String[] args) {
//		System.out.println(calculate("13-2-2"));
//		System.out.println(calculate("13+2-2"));
//		System.out.println(calculate("13-2+2"));
//		System.out.println(calculate("13+2*2"));
//		System.out.println(calculate(" 3/2 "));
		System.out.println(calculate("1*2-3/4+5*6-7*8+9/10"));
		
	}
}

package id;

import java.util.Stack;

public class Mathematical1 {
	/*
	 * Write a method which accepts a simple string mathematical expression, e.g.
	 * "1 - 3 + 2", which only contains + and - operators and valid integers, and
	 * returns the integer evaluation of the expression. Input: "12 - 19 + 2"
	 * Output: -5 Input: "121" Output: 121
	 */
	public static void main(String[] args) {
		System.out.println(mathematical("1 - 3 + 2"));
		System.out.println(mathematical("12 - 19 + 2"));
		System.out.println(mathematical("121"));
	}

	static int mathematical(String str) {
		String[] strs = str.split(" ");
		Stack<Integer> stack = new Stack<Integer>();
		int idx = 0;
		while (idx < strs.length) {
			int temp = 0;
			if (strs[idx].equals("+")) {
				temp = stack.pop() + Integer.valueOf(strs[idx + 1]);
				idx = idx + 2;
			} else if (strs[idx].equals("-")) {
				temp = stack.pop() - Integer.valueOf(strs[idx + 1]);
				idx = idx + 2;
			} else {
				temp = Integer.valueOf(strs[idx]);
				idx++;
			}
			stack.add(temp);
		}

		return stack.pop();
	}
}

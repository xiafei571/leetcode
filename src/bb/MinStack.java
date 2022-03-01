package bb;

import java.util.Stack;

public class MinStack {// 155
	private Stack<Integer[]> stack;

	public MinStack() {
		stack = new Stack<Integer[]>();
	}

	public void push(int val) {
		if (stack.isEmpty()) {
			stack.push(new Integer[] { val, val });
		} else {
			int currMin = stack.peek()[1];
			stack.push(new Integer[] { val, Math.min(val, currMin) });
		}
	}

	public void pop() {
		stack.pop();
	}

	public int top() {
		return stack.peek()[0];
	}

	public int getMin() {
		return stack.peek()[1];
	}
}

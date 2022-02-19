package am;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpanner {
//901 monotonous increase stack 
	//input [100,80,60,70,60,75,85]
	//output [1,1,1,2,1,4,6] 
	// defined as the maximum number of consecutive days (starting from today and going backward) for 
	// which the stock price was less than or equal to today's price.
	Stack<Integer> stack;
	List<Integer> list;

	public StockSpanner() {
		stack = new Stack<Integer>();
		list = new ArrayList<Integer>();
	}

	public int next(int price) {
		list.add(price);
		int idx = list.size() - 1;
		int res = 0;

		while (!stack.isEmpty() && list.get(stack.peek()) <= price) {
			stack.pop();
		}

		if (stack.isEmpty()) {
			res = idx + 1;
		} else {
			res = idx - stack.peek();
		}
		stack.add(idx);

		return res;
	}
}

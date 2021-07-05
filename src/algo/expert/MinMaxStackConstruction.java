package algo.expert;

import java.util.ArrayList;
import java.util.List;

public class MinMaxStackConstruction {
	// Feel free to add new properties and methods to the class.
	static class MinMaxStack {
		List<Integer> stack = new ArrayList<Integer>();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		public int peek() {
			// Write your code here.
			if (stack.size() == 0)
				return -1;

			return stack.get(stack.size() - 1);
		}

		public int pop() {
			// Write your code here.
			if (stack.size() == 0)
				return -1;
			int top = stack.get(stack.size() - 1);
			stack.remove(stack.size() - 1);
			newMinMax(top);
			return top;
		}

		public void push(Integer number) {
			// Write your code here.
			updateMinMax(number);
			stack.add(number);
		}

		public int getMin() {
			// Write your code here.
			if (stack.size() == 0)
				return -1;
			return min;
		}

		public int getMax() {
			// Write your code here.
			if (stack.size() == 0)
				return -1;
			return max;
		}

		private void updateMinMax(int value) {
			if (value < min) {
				min = value;
			}

			if (value > max) {
				max = value;
			}
		}

		private void newMinMax(int value) {
			if (value == min) {
				min = Integer.MAX_VALUE;
				for (int number : stack) {
					if (number < min) {
						min = number;
					}
				}
			}

			if (value == max) {
				max = Integer.MIN_VALUE;
				for (int number : stack) {
					if (number > max) {
						max = number;
					}
				}
			}
		}
	}
}

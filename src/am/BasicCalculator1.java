package am;

import java.util.Stack;

public class BasicCalculator1 {
	
	public static void main(String[] args) {
		System.out.println(calculate("2-1 + 2 "));
		System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
	}
	
	public static int calculate(String s) {
		s = s.replaceAll(" ", "");
		Stack<Integer> numbers = new Stack<Integer>();
		Stack<Character> operations = new Stack<Character>();

		int idx = 0;
		while (idx < s.length()) {
			
			char ch = s.charAt(idx);
			
			if (Character.isDigit(ch)) {
				int cur = 0;
				while(idx < s.length() && Character.isDigit(s.charAt(idx))) {
					cur = cur * 10 + s.charAt(idx) - '0';
					idx++;
				}
				numbers.push(cur);
			}

			if (idx < s.length() && !Character.isDigit(s.charAt(idx))) {
				if (s.charAt(idx) == ')') {
					while (!operations.isEmpty() && operations.peek() != '(') {
						char operation = operations.pop();
						
						int y = numbers.pop();
						int x = numbers.pop();

						if (operation == '+') {
							numbers.push(x + y);
						} else if (operation == '-') {
							numbers.push(x - y);
						}
					}
					if(operations.size() > 0)
						operations.pop();
				}else if (s.charAt(idx) == '(' || s.charAt(idx) == '+' || s.charAt(idx) == '-') {
					operations.push(s.charAt(idx));

				}  
				idx++;
			}
		}
		
		while(!operations.isEmpty()) {
			char operation = operations.pop();
			
			int y = numbers.pop();
			int x = numbers.pop();

			if (operation == '+') {
				numbers.push(x + y);
			} else if (operation == '-') {
				numbers.push(x - y);
			}
		}
		
		
		return numbers.pop();
	}
}

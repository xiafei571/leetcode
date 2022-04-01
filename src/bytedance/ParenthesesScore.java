package bytedance;

import java.util.Stack;

public class ParenthesesScore {
	public static void main(String[] args) {
		System.out.println(parenthesesScore("()"));
		System.out.println(parenthesesScore("()()"));
		System.out.println(parenthesesScore("(())"));
		System.out.println(parenthesesScore("(()())"));
		System.out.println(parenthesesScore("(()()())"));
		System.out.println(parenthesesScore("((()))"));
		
	}
	
	private static int parenthesesScore(String str) {
		int currSum = 0;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '(') {
				stack.add(currSum);
				currSum = 0;
			}else {// ")"
				if(currSum == 0) {// ()
					currSum = 1;
				}else { // (A)
					currSum = currSum * 2;
				}
				currSum += stack.pop();
			}
		}
		
		return currSum;
	}
}

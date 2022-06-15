package kt;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Calculator {
	/*
	 * 计算器+- follow up 带括号 定义一个res和LastOperator, 然后找数字，找到数字就做basicCal
	 * 定义一个numberStack, 再定义一个OperatorLevelStack,
	 * 跟上图一样，如果是数字就找数字，是括号就+-level，是操作符就判断栈顶level和当前level，把大于等于当前level的操作符全出栈，
	 * 最后再check一下OperatorLevelStack
	 */
	public static void main(String[] args) {
		String s1 = "1+10";
		String s2 = "2-1+200";
		String s3 = "(1+(4+5+2)-3)+(6+8)";// 23
		String s4 = "1-(2+(3-4))-5";// -5
		System.out.println(calculate1(s1));
		System.out.println(calculate1(s2));
		System.out.println(calculate2(s3));
		System.out.println(calculate2(s4));
	}

	public static int calculate1(String s) {
		int i = 0;
		int res = 0;
		char lastOperator = '+';
		while (i < s.length()) {
			char ch = s.charAt(i);
			if (isNumber(ch)) {
				String str = String.valueOf(ch);
				while (i + 1 < s.length() && isNumber(s.charAt(i + 1))) {
					str += String.valueOf(s.charAt(i + 1));
					i++;
				}
				Integer num = Integer.valueOf(str);
				res = basicCal(lastOperator, res, num);
			} else {
				lastOperator = ch;
			}

			i++;
		}

		return res;
	}

	private static int basicCal(char operator, int num1, int num2) {
		if (operator == '+') {
			return num1 + num2;
		} else if (operator == '-') {
			return num1 - num2;
		} else {
			return 0;
		}
	}

	static class OperatorLevel {
		char operator;
		int level;

		public OperatorLevel(char operator, int level) {
			this.operator = operator;
			this.level = level;
		}

		public String toString() {
			return " [" + operator + "," + level + "] ";
		}
	}

	static public int calculate2(String s) {
		Set<Character> operator = new HashSet<Character>();
		operator.add('+');
		operator.add('-');

		Set<Character> parenthesis = new HashSet<Character>();
		parenthesis.add('(');
		parenthesis.add(')');

		Deque<Integer> numberStack = new LinkedList<Integer>();
		Deque<OperatorLevel> operatorStack = new LinkedList<OperatorLevel>();

		int i = 0;
		int curLevel = 0;
		while (i < s.length()) {
			char ch = s.charAt(i);
			if (isNumber(ch)) {
				String str = String.valueOf(ch);
				while (i + 1 < s.length() && isNumber(s.charAt(i + 1))) {
					str += String.valueOf(s.charAt(i + 1));
					i++;
				}
				numberStack.add(Integer.valueOf(str));
			} else if (ch == '(') {
				curLevel++;
			} else if (ch == ')') {
				curLevel--;
			} else {// operator
				if (operatorStack.isEmpty()) {
					operatorStack.add(new OperatorLevel(ch, curLevel));
				} else {
					while (!operatorStack.isEmpty() && curLevel <= operatorStack.peekLast().level) {
						Integer num2 = numberStack.pollLast();
						Integer num1 = numberStack.pollLast();
						OperatorLevel op = operatorStack.pollLast();
						numberStack.add(basicCal(op.operator, num1, num2));
					}
					operatorStack.add(new OperatorLevel(ch, curLevel));
				}
			}
			i++;
		}

		while (!operatorStack.isEmpty()) {
			Integer num2 = numberStack.pollLast();
			Integer num1 = numberStack.pollLast();
			OperatorLevel op = operatorStack.pollLast();
			numberStack.add(basicCal(op.operator, num1, num2));
		}

		return numberStack.poll();
	}

	private static boolean isNumber(char ch) {
		return ch - '0' >= 0 && ch - '0' <= 9;
	}
}

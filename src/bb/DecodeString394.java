package bb;

import java.util.Stack;

public class DecodeString394 {
	public String decodeString(String s) {
		StringBuilder currString = new StringBuilder();
		Stack<Integer> countStack = new Stack<Integer>();
		Stack<StringBuilder> stringStack = new Stack<StringBuilder>();

		int k = 0;
		for (char ch : s.toCharArray()) {
			if (isNum(ch)) {
				k = k * 10 + ch - '0';
			} else if (ch == '[') {
				countStack.push(k);
				stringStack.push(currString);
				currString = new StringBuilder();
				k = 0;
			} else if (ch == ']') {
				StringBuilder decodeString = stringStack.pop();
				int currK = countStack.pop();
				while (currK > 0) {
					decodeString.append(currString);
					currK--;
				}
				currString = decodeString;
			} else {
				currString.append(ch);
			}
		}
		return currString.toString();
	}

	private boolean isNum(char ch) {
		return ch - '0' >= 0 && ch - '9' <= 9;
	}
}

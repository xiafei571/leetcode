package indeed;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * leetcode 224. Basic Calculator
 *
 */
public class Mathematical2 {
	/*
	 * Same aim as Q1 above, but this time the expression includes nested
	 * expressions, e.g. "12 + 2 + ((4 - 19) - 1)" containing ( and ) brackets only.
	 * Evaluate and return the answer to this expression. Input: "12 - (1 - 2)"
	 * Output: 13
	 * 
	 * 15 - (12 - (1 - 2))
	 */
	public static void main(String[] args) {
		System.out.println(mathematical2("12 + 2 + ((4 - 19) - 1)"));
		System.out.println(mathematical2("12 - (1 - 2)"));
	}
	
	static int mathematical2(String str) {
		List<String> list = new ArrayList<String>();
		str = str.replace(" ", "");
		String tempStr = "";
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) <='9' && str.charAt(i) >='0') {
				tempStr+=str.charAt(i);
			}else {
				if(tempStr.length() > 0) {
					list.add(tempStr);
					tempStr="";
				}
				list.add(String.valueOf(str.charAt(i)));
			}
		}
		if(tempStr.length() > 0) {
			list.add(tempStr);
			tempStr="";
		}
		
		Stack<String> stack = new Stack<String>();
		for(String s : list){
			if(s.equals(")")){
				String temp = "";
				while(!stack.empty()) {
					String pre = stack.pop();
					if(pre.equals("(")) {
						stack.add(String.valueOf(mathematical(temp)));
						break;
					}
					temp = pre +" "+ temp;
				}
			}else {
				stack.add(s);
			}
		}
		
		String result = "";
		while(!stack.empty()) {
			result = stack.pop() +" "+ result;
		}
		
		return mathematical(result);
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

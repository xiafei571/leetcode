package indeed;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidatePython {
	/*
	 * 规则1，第一行的code必须没有缩进，
	 * 规则2，尾巴是冒号的行一定是control statement，
	 * 规则3，control statement下面一行一定要有更多的缩进，
	 * 规则4，同一个block里面的缩进一定要相同。
	 */

	/*
	 * 比较有趣的follow-up是stack装不下会自动扩展，
	 * 自动扩展需要把原来的数据复制到一个新的大一些的stack里面，
	 * 问这个复制的过程会影响时间复杂度吗？
	 * 
	 * 当然不会，X insertions take O(2X) time, 所以insertion的amortized time仍然是O(1).面试官还问了我几遍are you sure.我sure的一笔，怎么会上你的当
	 */
	private static boolean validate(String[] lines) {
		List<String> list = new ArrayList<String>();
		for(String line : lines) {
			int tab = getTab(line);
			if(list.size() == 0 && tab != 0) {
				System.out.println(line);
				return false;
			}
			
			if(tab == 0 && list.size() == 0) {
				list.add(line);
			}else {
				String preLine = list.get(list.size() - 1);
				int preTab = getTab(preLine);

				if (isControl(preLine)) {
					if (tab != preTab + 1) {
						System.out.println(line);
						return false;
					} else {
						list.add(line);
					}
				} else {
					if (tab > preTab) {
						System.out.println(line);
						return false;
					} else {
						list.add(line);
					}
				}
			}
		}

		return true;
	}
	
	public static boolean isControl(String line) {
		return line.charAt(line.length() - 1) == ':';
	}
	
	public static int getTab(String line) {
		int tab = 0;
		for(int i = 0; i < line.length(); i++) {
			if(line.charAt(i) != ' ') {
				return tab;
			}else {
				tab++;
			}
		}
		return tab;
	}
	
	public static void main(String[] args) {
        String[] lines = {
                "def printArr(arr):",
                " for i in range(len(arr)):",
                "  if a > b:",
                "   print(1)",
                "  print(i)",
                " print(0)",
                "def getSum(a, b):",
                " return a + b",
                "def get(a, b):",
                "  return a - b"
        };
        System.out.println(validate(lines));
        System.out.println(validateStack(lines));
        
        String[] lines2 = {
        		"def function():",
        		" print(Hello world)",
        		" print(Hello world)",
        		" if i==1:",
        		"  print(asdf)"};
        System.out.println(validate(lines2));
        System.out.print(validateStack(lines2));
    }
	
	public static boolean validateStack(String[] lines){
        //就用stack来存之前的line就行
        Stack<String> stack = new Stack<>();
		for (String line : lines) {
			int tab = getTab(line);
			
			if (stack.isEmpty()) {// 先检查是不是第一行
				if (tab != 0) {
					System.out.println(line);
					return false;
				}
			} else if (isControl(stack.peek())) {// 再检查上一行是不是control statement
				if (getTab(stack.peek()) + 1 != tab) {
					System.out.println(line);
					return false;
				}
			} else {
				while (!stack.isEmpty() && getTab(stack.peek()) > tab) {
					stack.pop();
				}
				if (getTab(stack.peek()) != tab) {
					System.out.println(line);
					return false;
				}
			}
			stack.push(line);
		}
        return true;
    }
}

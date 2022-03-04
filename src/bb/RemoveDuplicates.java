package bb;

import java.util.Stack;

public class RemoveDuplicates {
	class Event {
		char ch;
		int count;

		public Event(char ch, int count) {
			this.ch = ch;
			this.count = count;
		}
	}

	public String removeDuplicates(String s, int k) {
		Stack<Event> stack = new Stack<Event>();
		StringBuilder sb = new StringBuilder(s);

		for (int i = 0; i < sb.length(); i++) {
			char ch = sb.charAt(i);
			if (stack.isEmpty() || stack.peek().ch != ch) {
				stack.add(new Event(ch, 1));
			} else {
				Event last = stack.pop();
				last.count = last.count + 1;
				if (last.count == k) {
					sb.delete(i - k + 1, i + 1);
					i = i - k;
				} else {
					stack.add(last);
				}

			}
		}

		return sb.toString();
	}
}

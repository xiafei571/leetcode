package algo.expert;

import java.util.*;

public class ReverseWordsInString {
	public String reverseWordsInString(String string) {
		// Write your code here.
		List<String> list = new ArrayList<String>();
		int j = string.length();
		for (int i = string.length() - 1; i >= 0; i--) {
			if (i == 0 || string.charAt(i - 1) == ' ') {
				list.add(string.substring(i, j));
				j = i - 1;
			}
		}
		return String.join(" ", list);
	}
}

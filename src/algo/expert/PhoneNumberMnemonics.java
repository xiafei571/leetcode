package algo.expert;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumberMnemonics {
	static String[] keypad = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
		// Write your code here.
		ArrayList<String> result = new ArrayList<String>();

		if (phoneNumber == null || phoneNumber == "") {
			return result;
		}

		List<String> curr_str = new ArrayList<String>();
		char[] array = phoneNumber.toCharArray();
		helper(result, curr_str, array, 0);

		// sb.deleteCharAt(sb.length() - 1);
		return result;
	}

	private static String arrayToString(List<String> curr_str) {
		StringBuilder sb = new StringBuilder();
		for (String s : curr_str) {
			sb.append(s);
		}
		return sb.toString();
	}

	private static void helper(ArrayList<String> result, List<String> curr_str, char[] array, int curr) {
		if (curr == array.length) {
			result.add(arrayToString(curr_str));
			return;
		}

		char c = array[curr];
		if (c >= '0' && c < '2') {
			curr_str.add(String.valueOf(c));
			helper(result, curr_str, array, curr + 1);
		} else if (c >= '2' && c <= '9') {
			int idx = Integer.valueOf(String.valueOf(c));
			String words = keypad[idx];
			for (String word : words.split("")) {
				curr_str.add(word);
				List<String> new_str = new ArrayList<String>(curr_str);
				helper(result, new_str, array, curr + 1);
				curr_str.remove(curr_str.size() - 1);
			}
		}
	}
}

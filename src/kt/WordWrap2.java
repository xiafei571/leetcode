package kt;

import java.util.ArrayList;
import java.util.List;

public class WordWrap2 {
	/**
	 * lt68: We are building a word processor and we would like to implement a
	 * "reflow" functionality that also applies full justification to the text.
	 * Given an array containing lines of text and a new maximum width, re-flow the
	 * text to fit the new width. Each line should have the exact specified width.
	 * If any line is too short, insert '-' (as stand-ins for spaces) between words
	 * as equally as possible until it fits. Note: we are using '-' instead of
	 * spaces between words to make testing and visual verification of the results
	 * easier.
	 * 
	 */

	public static void main(String[] args) {
		String[] words2 = { "If", "liberty", "means", "anything", "at", "all", "it", "means", "the", "right", "to",
				"tell", "people", "what", "they", "do", "not", "want", "to", "hear." };
		List<String> res = fullJustify(words2, 20);
		for (String line : res) {
			System.out.println(line);
		}
	}

	public static List<String> fullJustify(String[] words, int k) {

		List<String> temp = new ArrayList<>();
		List<String> res = new ArrayList<String>();
		temp.add(words[0]);
		int remain = k - temp.get(0).length();
		for (int i = 1; i < words.length; i++) {
			String word = words[i];
			if (word.length() + 1 <= remain) {
				temp.add(word);
				remain = remain - word.length() - 1;
			} else {
				res.add(justify(temp, k, false));
				temp = new ArrayList<>();
				temp.add(word);
				remain = k - temp.get(0).length();
			}
		}
		res.add(justify(temp, k, true));
		return res;

	}

	private static String justify(List<String> temp, int maxWidth, boolean isLastLine) {
		StringBuilder sb = new StringBuilder();

		if (isLastLine) {
			sb.append(temp.get(0));
			for (int i = 1; i < temp.size(); i++) {
				sb.append("-").append(temp.get(i));
			}
			int curLen = sb.length();
			if (sb.length() < maxWidth) {
				for (int i = 0; i < maxWidth - curLen; i++) {
					sb.append("-");
				}
			}
			return sb.toString();
		}

		int curWidth = temp.size() - 1;
		for (String str : temp) {
			curWidth += str.length();
		}

		int remain = maxWidth - curWidth;
		if (temp.size() == 1) {
			sb.append(temp.get(0));
			int curLen = sb.length();
			if (sb.length() < maxWidth) {
				for (int i = 0; i < maxWidth - curLen; i++) {
					sb.append("-");
				}
			}
			return sb.toString();
		}
		int space = remain / (temp.size() - 1);

		int add = remain % (temp.size() - 1);

		for (int i = 0; i < temp.size(); i++) {
			sb.append(temp.get(i));
			if (i == temp.size() - 1)
				break;
			sb.append("-").append(getSplit(space));
			if (i < add) {
				sb.append("-");
			}
		}
		return sb.toString();
	}

	private static String getSplit(int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append("-");
		}
		return sb.toString();
	}
}

package indeed;

import java.util.ArrayList;
import java.util.List;

public class FullJustify68 {

	final static String FILL = "-";

	/**
	 * 输出: [ "This----is----an", "example of text", "justification. " ]
	 * 
	 * @param words
	 * @param maxWidth
	 * @return
	 */
	public static List<String> fullJustify(String[] words, int maxWidth) {
		List<String> result = new ArrayList<String>();
		int start = 0;
		int end = 1;

		while (start < words.length) {
			int currentWidth = words[start].length();
			int currentSpace = maxWidth - currentWidth;
			while (end < words.length && currentSpace > words[end].length()) {
				currentSpace = currentSpace - (1 + words[end].length());
				end++;
			}

			int everySpace = 1;
			int extSpace = 0;
			if (currentSpace > 0) {
				int remain = end - start - 1;
				if (remain != 0) {
					everySpace += currentSpace / remain;
					extSpace = currentSpace % remain;
				}
			}

			StringBuilder sb = new StringBuilder();
			for (int i = start; i < words.length && i < end; i++) {

				if (end - 1 == words.length - 1) {// last line(align left)
					everySpace = 1;
					extSpace = 0;
				}

				if (i == words.length - 1 || end - start == 1) {
					String space = generateSpace(currentSpace);
					sb.append(words[i] + space);
				} else if (i == end - 1) {
					sb.append(words[i]);
				} else {
					StringBuilder space = new StringBuilder(generateSpace(everySpace));
					if (extSpace > 0) {
						space.append(FILL);
						extSpace--;
					}
					sb.append(words[i] + space);
				}
			}
			result.add(sb.toString());

			start = end;
			end = start + 1;
		}

		return result;
	}

	private static String generateSpace(int count) {
		StringBuilder sb = new StringBuilder();
		while (count > 0) {
			sb.append(FILL);
			count--;
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		String[] words1 = { "This", "is", "an", "example", "of", "text", "justification." };
		int maxWidth1 = 16;
		List<String> result1 = fullJustify(words1, maxWidth1);
		printResult(result1);

		String[] words2 = { "What", "must", "be", "acknowledgment", "shall", "be" };
		int maxWidth2 = 16;
		List<String> result2 = fullJustify(words2, maxWidth2);
		printResult(result2);

		String[] words3 = { "Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a",
				"computer.", "Art", "is", "everything", "else", "we", "do" };
		int maxWidth3 = 20;
		List<String> result3 = fullJustify(words3, maxWidth3);
		printResult(result3);
	}

	private static void printResult(List<String> result) {
		for (String s : result) {
			System.out.println(s);
		}
		System.out.println();
	}
}

package kt;

import java.util.ArrayList;
import java.util.List;

public class WordWrap1 {
	/**
	 * 把input中的word拼成句子，词和词之间用-相隔开，每个句子不能超过k的长度。 input: ['nice', 'to',
	 * 'meet','you'], 7 output: ['nice-to', 'meet', 'you']
	 * 
	 */
	public static void main(String[] args) {
		String[] words1 = { "nice", "to", "meet", "you" };
		wordWrap(words1, 7);
		System.out.println("- - - - - - - - - - ");
		String[] words2 = { "If", "liberty", "means", "anything", "at", "all", "it", "means", "the", "right", "to",
				"tell", "people", "what", "they", "do", "not", "want", "to", "hear." };
		wordWrap(words2, 20);
	}

	private static void wordWrap(String[] words, int k) {
		StringBuilder temp = new StringBuilder(words[0]);
		List<String> res = new ArrayList<String>();
		int remain = k - temp.length();
		for (int i = 1; i < words.length; i++) {
			String word = words[i];
			if (word.length() + 1 <= remain) {
				temp.append("-").append(word);
				remain = k - temp.length();
			} else {
				res.add(temp.toString());
				temp = new StringBuilder(words[i]);
				remain = k - words[i].length();
			}
		}
		res.add(temp.toString());
		for (String line : res) {
			System.out.println(line);
		}
	}
}

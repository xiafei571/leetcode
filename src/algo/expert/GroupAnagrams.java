package algo.expert;

import java.util.*;

public class GroupAnagrams {
	public static List<List<String>> groupAnagrams(List<String> words) {
		// Write your code here.
		Map<String, List<String>> anagrams = new HashMap<String, List<String>>();

		for (String word : words) {
			String sortedWord = getSortedWord(word);
			if (anagrams.containsKey(sortedWord)) {
				anagrams.get(sortedWord).add(word);
			} else {
				List<String> newlist = new ArrayList<String>();
				newlist.add(word);
				anagrams.put(sortedWord, newlist);
			}
		}

		return new ArrayList<List<String>>(anagrams.values());
	}

	private static String getSortedWord(String word) {
		char[] charArray = word.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}
}

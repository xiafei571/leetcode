package am;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord819 {
	public String mostCommonWord(String paragraph, String[] banned) {
		Set<String> set = new HashSet<String>();
		for (String s : banned) {
			set.add(s);
		}

		Map<String, Integer> map = new HashMap<String, Integer>();
		paragraph = paragraph.replaceAll("[^\\w]", " ");
		String[] strs = paragraph.split("\\s");
		String mostCommonWord = "";
		int mostTime = 0;
		for (String str : strs) {
			String word = str.toLowerCase();
			// System.out.println(word);
			if (word.length() == 0 || set.contains(word)) {
				continue;
			}
			int times = map.getOrDefault(word, 0) + 1;
			if (times > mostTime) {
				mostTime = times;
				mostCommonWord = word;
			}
			map.put(word, times);
		}

		return mostCommonWord;
	}
}

package algo.mock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordCountEngine {

	public static void main(String[] args) {
		String document = "Practice makes perfect. you'll only get Perfect by practice. just practice!";
		String[][] res = wordCountEngine(document);
		for (String[] s : res) {
			System.out.println(s[0] + ":" + s[1]);
		}
	}

	static String[][] wordCountEngine(String document) {
		// your code goes here
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		document = document.toLowerCase();
		document = document.replaceAll("[^\\w\\s]", "");
		
		int left = 0;
		int right = 0;
		while (left < document.length() && right < document.length()) {
			while (!isAlphabel(document.charAt(left))) {
				left++;
			}
			right = left+1;
			while (right < document.length() && isAlphabel(document.charAt(right))) {
				right++;
			}
			String subStr = document.substring(left, right);
			int times = map.getOrDefault(subStr, 0);
			map.put(subStr, times + 1);
			left = right+1;
		}
		String[][] res = new String[map.keySet().size()][2];

		List<String[]> list = new ArrayList<String[]>();
//		int idx = 0;
		for (String key : map.keySet()) {
			list.add(new String[] {key, String.valueOf(map.get(key))});
//			res[idx][0] = key;
//			res[idx][1] = String.valueOf(map.get(key));
//			idx++;
		}
		
		Collections.sort(list, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				int num1 = Integer.valueOf(o1[1]);
				int num2 = Integer.valueOf(o2[1]);
				return num2 - num1;
			}
		});

		return list.toArray(new String[list.size()][2]);
	}


	static boolean isAlphabel(char ch) {
		return ch >= 'a' && ch <= 'z';
	}
}

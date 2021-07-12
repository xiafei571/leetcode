package id;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	/**
	 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"] 输出: [ ["ate","eat","tea"],
	 * ["nat","tan"], ["bat"] ]
	 * 
	 * @param args
	 */

	public static List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();

		for (String str : strs) {
			String sortKey = sortStr(str);
			List<String> list = map.getOrDefault(sortKey, new ArrayList<String>());
			list.add(str);
			map.put(sortKey, list);
		}
		
		List<List<String>> result = new ArrayList<List<String>>();
		for(String key : map.keySet()) {
			result.add(map.get(key));
		}
		return result;
	}

	public static String sortStr(String s) {
		char[] cs = s.toCharArray();
		Arrays.sort(cs);
		StringBuilder sb = new StringBuilder();
		for (char c : cs) {
			sb.append(c);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		List<List<String>> result = groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" });
		for (List<String> list : result) {
			for (String s : list) {
				System.out.print(s + " ");
			}
			System.out.println();
		}
	}

}

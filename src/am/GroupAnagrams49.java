package am;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams49 {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> results = new ArrayList<List<String>>();

		Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
		for (int i = 0; i < strs.length; i++) {
			String sorted = sortString(strs[i]);
			List<Integer> idxList = map.getOrDefault(sorted, new ArrayList<Integer>());
			idxList.add(i);
			map.put(sorted, idxList);
		}

		for (String key : map.keySet()) {
			List<Integer> idxList = map.get(key);
			List<String> result = new ArrayList<String>();
			for (Integer idx : idxList) {
				result.add(strs[idx]);
			}
			results.add(result);
		}

		return results;
	}

	private static String sortString(String str) {
		char[] ar = str.toCharArray();
		Arrays.sort(ar);
		String sorted = String.valueOf(ar);
		return sorted;
	}
}

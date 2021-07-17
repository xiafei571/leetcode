package am;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent692 {

	public static void main(String[] args) {
		// ["i", "love", "leetcode", "i", "love", "coding"], k = 2

		String[] input = { "i", "love", "leetcode", "i", "love", "coding" };
		int k = 2;
		List<String> result = topKFrequent(input, k);
		for (String s : result) {
			System.out.println(s);
		}
	}

	public static List<String> topKFrequent(String[] words, int k) {
		List<String> result = new ArrayList<String>();

		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}

		PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<Map.Entry<String, Integer>>(
				new Comparator<Map.Entry<String, Integer>>() {

					@Override
					public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
						if (o1.getValue() == o2.getValue()) {
							return o1.getKey().compareTo(o2.getKey());
						} else {
							return o2.getValue() - o1.getValue();
						}
					}
				});

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			pq.add(entry);
		}

		for (int i = 0; i < k; i++) {
			result.add(pq.poll().getKey());
		}
		return result;
	}
}

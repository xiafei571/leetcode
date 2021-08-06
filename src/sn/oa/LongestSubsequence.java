package sn.oa;

import java.util.HashMap;
import java.util.Map;

public class LongestSubsequence {

	public static void main(String[] args) {
		longestSubsequence();
	}

	private static void longestSubsequence() {
		//找合为target的最长的子串的长度
		int[] arr = { 5, 3, 2, 1 };
		int target = 6;
		Map<Integer, Boolean> m_exist = new HashMap<Integer, Boolean>();
		Map<Integer, Integer> m_pos = new HashMap<Integer, Integer>();
		int max = 0;
		int sum = 0;
		m_exist.put(0, true); // 在数组的开头放入假想的数字0
		m_pos.put(0, -1);

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (null == m_exist.get(sum) || !m_exist.get(sum)) {
				m_exist.put(sum, true);
				m_pos.put(sum, i);
			}
			if (m_exist.get(sum - target) != null && m_exist.get(sum - target))
				max = Math.max(max, i - m_pos.get(sum - target));
		}
		System.out.println(max);

	}
}

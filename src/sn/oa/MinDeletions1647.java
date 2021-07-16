package sn.oa;

import java.util.HashSet;
import java.util.Set;

public class MinDeletions1647 {
	public int minDeletions(String s) {
		if (s == null || s.length() <= 1) {
			return 0;
		}

		int[] ss = new int[26];
		for (int i = 0; i < s.length(); i++) {
			ss[s.charAt(i) - 'a']++;
		}

		Set<Integer> set = new HashSet<Integer>();
		int res = 0;

		for (int i = 0; i < ss.length; i++) {
			int times = ss[i];
			while (set.contains(times) && times > 0) {
				times--;
				res++;
			}

			if (times != 0) {
				set.add(times);
			}
		}

		return res;
	}
}

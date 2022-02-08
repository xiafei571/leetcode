package bytedance;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AddBoldTag616 {
	
	//Time Limit Exceeded
	public String addBoldTag(String s, String[] words) {
		Set<String> set = new HashSet<String>();
		for (String word : words) {
			set.add(word);
		}

		StringBuilder res = new StringBuilder();
		int left = 0;
		int right = 1;

		List<Integer[]> bold = new ArrayList<Integer[]>();

		while (left < s.length()) {
			while (right <= s.length()) {
				if (set.contains(s.substring(left, right))) {
					if (bold.size() == 0) {
						bold.add(new Integer[] { left, right });
					} else {// update
						Integer[] pre = bold.get(bold.size() - 1);
						if (left <= pre[1]) {
							bold.remove(bold.size() - 1);
							bold.add(new Integer[] { pre[0], Math.max(pre[1], right) });
						} else {
							bold.add(new Integer[] { left, right });
						}
					}

				}
				right++;
			}
			left++;
			right = left + 1;
		}

		// for(Integer[] b : bold){
		// System.out.print(b[0]+":"+b[1]+" ");
		// }
		// System.out.println();

		if (bold.size() == 0) {
			return s;
		} else {
			int p1 = 0;
			int p2 = 0;
			while (p1 <= s.length()) {
				if (p2 < bold.size()) {
					if (p1 == bold.get(p2)[0]) {
						res.append("<b>");
					} else if (p1 == bold.get(p2)[1]) {
						res.append("</b>");
						p2++;
					}
				}
				if (p1 < s.length())
					res.append(String.valueOf(s.charAt(p1)));
				p1++;
			}
		}

		return res.toString();
	}
}

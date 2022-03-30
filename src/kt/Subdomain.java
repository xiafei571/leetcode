package kt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subdomain {
	public List<String> subdomainVisits(String[] cpdomains) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String cpdomain : cpdomains) {// Time Complexity: O(N), where N is the length of cpdomains
			String[] cp = cpdomain.split(" ");
			Integer new_visits = Integer.valueOf(cp[0]);
			String domain = cp[1];

			String[] domains = domain.split("\\.");
			String key = "";
			for (int i = domains.length - 1; i >= 0; i--) {
				if (i == domains.length - 1) {
					key += domains[i];
				} else {
					key = domains[i] + "." + key;
				}
				Integer cur_visits = map.getOrDefault(key, 0);
				cur_visits += new_visits;
				map.put(key, cur_visits);
			}
		}

		List<String> res = new ArrayList<String>();

		for (String domain : map.keySet()) {
			res.add(map.get(domain) + " " + domain);
		}

		return res;
	}
}

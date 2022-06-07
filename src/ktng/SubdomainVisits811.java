package ktng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisits811 {
	//1. Leetcode 811
	
	public List<String> subdomainVisits(String[] cpdomains) {
		List<String> res = new ArrayList<>();
		Map<String, Integer> subdomainVisitsMap = new HashMap<>();

		for (String cpdomain : cpdomains) {
			String[] temp = cpdomain.split(" ");
			Integer visit = Integer.valueOf(temp[0]);
			String domain = temp[1];

			String[] subdomains = domain.split("\\.");
			String subdomain = null;
			for (int i = subdomains.length - 1; i >= 0; i--) {
				if (subdomain == null) {
					subdomain = subdomains[i];
				} else {
					subdomain = subdomains[i] + "." + subdomain;
				}

				Integer curr = subdomainVisitsMap.getOrDefault(subdomain.toString(), 0);
				subdomainVisitsMap.put(subdomain.toString(), curr + visit);
			}
		}

		for (String subdomain : subdomainVisitsMap.keySet()) {
			res.add(subdomainVisitsMap.get(subdomain) + " " + subdomain);
		}

		return res;
	}
}

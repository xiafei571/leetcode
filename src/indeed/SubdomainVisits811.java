package indeed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisits811 {
	/**
	 * 输入: ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
	 * 输出: ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5
	 * org","1 intel.mail.com","951 com"]
	 * 
	 * @param cpdomains
	 * @return
	 */
	public static List<String> subdomainVisits(String[] cpdomains) {
		Map<String, Integer> counts = new HashMap<String, Integer>();
		for (String cpdomain : cpdomains) {
			String[] strs = cpdomain.split(" ");
			Integer count = Integer.valueOf(strs[0]);
			String addr = strs[1];

			String[] addrs = addr.split("\\.");
			String key = "";
			for (int i = addrs.length - 1; i >= 0; i--) {
				key = i == addrs.length - 1 ? addrs[i] : addrs[i] + "." + key;
				counts.put(key, counts.getOrDefault(key, 0) + count);
			}
		}

		List<String> result = new ArrayList<String>();
		for (String key : counts.keySet()) {
			result.add(counts.get(key) + " " + key);
		}
		
		return result;
	}

	public static void main(String[] args) {
		String[] input = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
		List<String> list = subdomainVisits(input);
		for(String s : list) {
			System.out.println(s);
		}
	}

}

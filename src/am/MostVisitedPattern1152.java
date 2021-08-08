package am;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MostVisitedPattern1152 {

	public static void main(String[] args) {
		System.out.println("home_about_career".compareTo("home_cart_maps"));

//		String[] username = { "joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary" };
//		int[] timestamp = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
//		String[] website = { "home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career" };

		String[] username = { "ua","ua","ua","ub","ub","ub" };
		int[] timestamp = { 1,2,3,4,5,6 };
		String[] website = {"a","b","a","a","b","c" };

		System.out.println(mostVisitedPattern(username, timestamp, website).size());
	}

	/**
	 * 
	 * @param username
	 * @param timestamp
	 * @param website
	 * @return
	 */
	public static List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
		Map<String, List<VisitInfo>> visitMap = new HashMap<String, List<VisitInfo>>();
		for (int i = 0; i < username.length; i++) {
			VisitInfo info = new VisitInfo(username[i], timestamp[i], website[i]);
			List<VisitInfo> list = visitMap.getOrDefault(username[i], new ArrayList<VisitInfo>());
			list.add(info);
			visitMap.put(username[i], list);
		}

		Map<String, Set<String>> visitPath = new HashMap<String, Set<String>>();
		for (String name : visitMap.keySet()) {
			List<VisitInfo> visits = visitMap.get(name);
			List<String> paths = getAllPath(visits);
			for (String path : paths) {
				Set<String> users = visitPath.getOrDefault(path, new HashSet<String>());
				users.add(name);
				visitPath.put(path, users);
			}
		}

		String mostVisited = "";
		int cnt = 0;

		for (String path : visitPath.keySet()) {
			Set<String> users = visitPath.get(path);
			if (users.size() > cnt) {
				mostVisited = path;
				cnt = users.size();
			} else if (users.size() == cnt) {
				mostVisited = mostVisited.compareTo(path) < 0 ? mostVisited : path;
			}
		}

		List<String> result = new ArrayList<String>(Arrays.asList(mostVisited.split("_")));
		return result;
	}

	private static List<String> getAllPath(List<VisitInfo> visits) {
		Collections.sort(visits, new Comparator<VisitInfo>() {
			@Override
			public int compare(VisitInfo o1, VisitInfo o2) {
				return o1.timestamp - o2.timestamp;
			}

		});
		
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < visits.size() - 2; i++) {
			for (int j = i + 1; j < visits.size() - 1; j++) {
				for (int k = j + 1; k < visits.size(); k++) {
					result.add(visits.get(i).website + "_" + visits.get(j).website + "_" + visits.get(k).website);
				}
			}
		}
		return result;
	}

	static class VisitInfo {
		String name;
		int timestamp;
		String website;

		public VisitInfo(String name, int timestamp, String website) {
			this.name = name;
			this.timestamp = timestamp;
			this.website = website;
		}

		@Override
		public String toString() {
			return "VisitInfo [name=" + name + ", timestamp=" + timestamp + ", website=" + website + "]";
		}
		
	}
}

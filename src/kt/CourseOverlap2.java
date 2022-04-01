package kt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseOverlap2 {
	public static void main(String[] args) {
		String[][] allCourses = { { "Logic", "COBOL" }, { "Data Structures", "Algorithms" },
				{ "Creative Writing", "Data Structures" }, { "Algorithms", "COBOL" },
				{ "Intro to Computer Science", "Data Structures" }, { "Logic", "Compilers" },
				{ "Data Structures", "Logic" }, { "Creative Writing", "System Administration" },
				{ "Databases", "System Administration" }, { "Creative Writing", "Databases" },
				{ "Intro to Computer Science", "Graphics" }, };
		List<String> allMidway = findAllMidway(allCourses);
		for(String str : allMidway) {
			System.out.println(str);
		}
	}

	private static List<List<String>> res = new ArrayList<List<String>>();

	/**
	 * Sample output (in any order):
          ["Data Structures", "Creative Writing", "Databases", "Intro to Computer Science"]
		
		All paths through the curriculum (midpoint *highlighted*):
		
		*Intro to C.S.* -> Graphics
		Intro to C.S. -> *Data Structures* -> Algorithms -> COBOL
		Intro to C.S. -> *Data Structures* -> Logic -> COBOL
		Intro to C.S. -> *Data Structures* -> Logic -> Compiler
		Creative Writing -> *Databases* -> System Administration
		*Creative Writing* -> System Administration
		Creative Writing -> *Data Structures* -> Algorithms -> COBOL
		Creative Writing -> *Data Structures* -> Logic -> COBOL
		Creative Writing -> *Data Structures* -> Logic -> Compilers

	 * @param allCourses
	 * @return
	 */
	private static List<String> findAllMidway(String[][] allCourses) {
		Map<String, Set<String>> courseGraph = new HashMap<String, Set<String>>();
		Map<String, Integer> indegress = new HashMap<String, Integer>();
		// build graph
		for (String[] pair : allCourses) {
			String parent = pair[0];
			String child = pair[1];

			if (!indegress.containsKey(parent)) {
				indegress.put(parent, 0);
			}

			Integer cnt = indegress.getOrDefault(child, 0);
			indegress.put(child, cnt + 1);

			Set<String> childs = courseGraph.getOrDefault(parent, new HashSet<String>());
			childs.add(child);
			courseGraph.put(parent, childs);
		}

		for (String course : indegress.keySet()) {
			if (indegress.get(course) == 0) {// is root
				List<String> path = new ArrayList<String>();
				path.add(course);
				dfs(course, courseGraph, path);
			}
		}

		Set<String> allMidSet = new HashSet<String>();
		for (List<String> list : res) {
			int mid = list.size() % 2 == 0? list.size()/2 - 1 : list.size()/2;
			allMidSet.add(list.get(mid));
		}
		
		List<String> allMidList = new ArrayList<String>(allMidSet);
		return allMidList;
	}

	private static void dfs(String course, Map<String, Set<String>> courseGraph, List<String> path) {// dfs
		if (courseGraph.get(course) == null || courseGraph.get(course).size() == 0) {// leaf
			res.add(path);
			return;
		}

		Set<String> childs = courseGraph.get(course);
		for (String child : childs) {
			List<String> newPath = new ArrayList<String>(path);
			newPath.add(child);
			dfs(child, courseGraph, newPath);
		}
	}
}

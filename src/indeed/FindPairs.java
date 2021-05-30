package indeed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindPairs {
	public static void main(String[] args) {
		String[][] pairs = { { "58", "Software Design" }, { "58", "Linear Algebra" }, { "94", "Art History" },
				{ "94", "Operating Systems" }, { "17", "Software Design" }, { "58", "Mechanics" },
				{ "58", "Economics" }, { "17", "Linear Algebra" }, { "17", "Political Science" }, { "94", "Economics" },
				{ "25", "Economics" }, };
		List<String> result = findPairs(pairs);
		for(String s : result) {
			System.out.println(s);
		}
	}
	
	/*
	 * Sample Output (pseudocode, in any order):

		find_pairs(student_course_pairs_1) =>
		{
		  [58, 17]: ["Software Design", "Linear Algebra"]
		  [58, 94]: ["Economics"]
		  [58, 25]: ["Economics"]
		  [94, 25]: ["Economics"]
		  [17, 94]: []
		  [17, 25]: []
		}
	 */
	private static List<String> findPairs(String[][] pairs){
		List<String> result = new ArrayList<String>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for(String[] pair : pairs) {
			List<String> courus =  map.getOrDefault(pair[0], new ArrayList<String>());
			courus.add(pair[1]);
			map.put(pair[0], courus);
		}
		
		
		List<String> students = new ArrayList<String>(map.keySet());
		for(int i = 0; i < students.size()-1;i++) {
			for(int j = i+1; j < students.size(); j++) {
				List<String> c1 = map.get(students.get(i));
				List<String> c2 = map.get(students.get(j));
				List<String> common = new ArrayList<String>();
				for(String s1 : c1) {
					for(String s2 : c2) {
						if(s1.equals(s2)) {
							common.add(s1);
						}
					}
				}
				String temp = students.get(i) + " " + students.get(j);
				for(String s : common) {
					temp += " " + s; 
				}
				
				result.add(temp);
			}
		}
		
		return result;
	}
}

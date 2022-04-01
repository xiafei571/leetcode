package kt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseOverlap1 {
	/**
	 * You are a developer for a university. Your current project is to develop a
	 * system for students to find courses they share with friends. The university
	 * has a system for querying courses students are enrolled in, returned as a
	 * list of (ID, course) pairs. Write a function that takes in a list of (student
	 * ID number, course name) pairs and returns, for every pair of students, a list
	 * of all courses they share.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String[][] studentCoursePairs1 = { { "58", "Linear Algebra" }, { "94", "Art History" },
				{ "94", "Operating Systems" }, { "17", "Software Design" }, { "58", "Mechanics" },
				{ "58", "Economics" }, { "17", "Linear Algebra" }, { "17", "Political Science" }, { "94", "Economics" },
				{ "25", "Economics" }, { "58", "Software Design" }, };

		coursePairs(studentCoursePairs1);
		String[][] studentCoursePairs2 = { { "42", "Software Design" }, { "0", "Advanced Mechanics" },
				{ "9", "Art History" }, };
		
		coursePairs(studentCoursePairs2);
	}
	
	private static void coursePairs(String[][] studentCoursePairs) {
		Map<String, Set<String>> studentCourses = new HashMap<>();
		for (String[] pairs : studentCoursePairs) {
			String studentId = pairs[0];
			String courseName = pairs[1];
			Set<String> courses = studentCourses.getOrDefault(studentId, new HashSet<String>());
			courses.add(courseName);
			studentCourses.put(studentId, courses);
		}

		List<String> students = new ArrayList<String>(studentCourses.keySet());
		Map<String, List<String>> res = new HashMap<String, List<String>>();
		for (int i = 0; i < students.size() - 1; i++) {
			for (int j = i+1; j < students.size(); j++) {
				String st1 = students.get(i);
				String st2 = students.get(j);
				List<String> share = new ArrayList<String>();
				Set<String> courses1 = studentCourses.get(st1);
				Set<String> courses2 = studentCourses.get(st2);
				if (courses1 != null && courses1.size() > 0) {
					for (String c2 : courses2) {
						if (courses1.contains(c2)) {
							share.add(c2);
						}
					}
				}
				res.put(st1 + "," + st2, share);
			}
		}
		
		for(String key : res.keySet()) {
			List<String> list = res.get(key);
			StringBuilder sb = new StringBuilder();
			sb.append(key).append(":");
			for(String course : list) {
				sb.append(course).append("    ");
			}
			System.out.println(sb.toString());
		}
	}
	/*
	 * Sample Input:
		student_course_pairs_1 = [
		  ["58", "Software Design"],
		  ["58", "Linear Algebra"],
		  ["94", "Art History"],
		  ["94", "Operating Systems"],
		  ["17", "Software Design"],
		  ["58", "Mechanics"],
		  ["58", "Economics"],
		  ["17", "Linear Algebra"],
		  ["17", "Political Science"],
		  ["94", "Economics"],
		  ["25", "Economics"],
		]
		
		Sample Output (pseudocode, in any order):
		
		find_pairs(student_course_pairs_1) =>
		{
		  [58, 17]: ["Software Design", "Linear Algebra"]
		  [58, 94]: ["Economics"]
		  [58, 25]: ["Economics"]
		  [94, 25]: ["Economics"]
		  [17, 94]: []
		  [17, 25]: []
		}
		
		Additional test cases:
		
		Sample Input:
		
		student_course_pairs_2 = [
		  ["42", "Software Design"],
		  ["0", "Advanced Mechanics"],
		  ["9", "Art History"],
		]
		
		Sample output:
		
		find_pairs(student_course_pairs_2) =>
		{
		  [0, 42]: []
		  [0, 9]: []
		  [9, 42]: []
		}
	 */
	
}

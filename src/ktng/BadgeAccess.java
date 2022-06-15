package ktng;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BadgeAccess {
	public static void main(String[] args) {
		String[][] badge_records = { { "Martha", "exit" }, // -1
				{ "Paul", "enter" }, //
				{ "Martha", "enter" }, // 0
				{ "Martha", "exit" }, // -1
				{ "Jennifer", "enter" }, { "Paul", "enter" }, //
				{ "Curtis", "enter" }, // 1
				{ "Paul", "exit" }, // 1
				{ "Martha", "enter" }, // 0
				{ "Martha", "exit" }, // -1
				{ "Jennifer", "exit" } };
		List<Set<String>> res = find_mismatched_entries(badge_records);
		// Expected output: ["Paul", "Curtis"], ["Martha"]
		Set<String> enter_without_exit = res.get(0);
		Set<String> exit_without_enter = res.get(1);

		for (String name : enter_without_exit) {
			System.out.print(name + ", ");
		}
		System.out.println();

		for (String name : exit_without_enter) {
			System.out.print(name + ", ");
		}
		System.out.println();
		
		
		String [][] badge_records2 =
			 {{"Paul", "1355"},
		     {"Jennifer", "1910"},
		     {"John", "830"},
		     {"Paul", "1315"},
		     {"John", "835"},
		     {"Paul", "1405"},
		     {"Paul", "1630"},
		     {"John", "855"},
		     {"John", "915"},
		     {"John", "930"},
		     {"Jennifer", "1335"},
		     {"Jennifer", "730"},
		     {"John", "1630"}
		     };

//			Expected output:
//			John: 830 835 855 915 930
//			Paul: 1315 1355 1405
		Map<String, List<Integer>> res2 = find_high_freq(badge_records2);
		for(String name : res2.keySet()) {
			List<Integer> records = res2.get(name);
			System.out.print(name+" ");
			for(Integer record : records) {
				System.out.print(" " + record +" ");
			}
			System.out.println();
		}

	}
	
	private static boolean withinOneHour(Integer time1, Integer time2) {
		
		return false;
	}
	
	private static Map<String, List<Integer>> find_high_freq(String [][] badge_records){
		Map<String, List<Integer>> res = new HashMap<>();
		Map<String, List<Integer>> records_map = new HashMap<>();
		
		for(String[] badge_record : badge_records) {
			String name = badge_record[0];
			Integer time = Integer.valueOf(badge_record[1]);
			
			List<Integer> records = records_map.getOrDefault(name, new ArrayList<>());
			records.add(time);
			records_map.put(name, records);
		}
		
		for(String name : records_map.keySet()) {
			List<Integer> records = records_map.get(name);
			Collections.sort(records);
			
			Deque<Integer> queue = new LinkedList<Integer>();
			List<Integer> curr_res = new LinkedList<Integer>();
			
			for(Integer record : records) {
				queue.addLast(record);
				
				while(record - queue.peekFirst() > 100) {
					queue.pollFirst();
				}
				
				if(queue.size() >= 3 && queue.size() > curr_res.size()) {
					curr_res.clear();
					curr_res.addAll(queue);
				}
			}
			res.put(name, curr_res);
		}
		
		return res;
	}

	private static List<Set<String>> find_mismatched_entries(String[][] badge_records) {
		Set<String> enter_without_exit = new HashSet<>();
		Set<String> exit_without_enter = new HashSet<>();
		Set<String> curr = new HashSet<>();

		for (String[] record : badge_records) {
			String name = record[0];
			String act = record[1];

			if (act.equals("enter")) {
				if (curr.contains(name)) {
					enter_without_exit.add(name);
				}
				curr.add(name);
			} else if (act.equals("exit")) {
				if (!curr.remove(name)) {
					exit_without_enter.add(name);
				}
			}
		}
		enter_without_exit.addAll(curr);
		List<Set<String>> res = new ArrayList<>();
		res.add(enter_without_exit);
		res.add(exit_without_enter);
		return res;
	}
}

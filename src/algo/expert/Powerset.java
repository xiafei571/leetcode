package algo.expert;

import java.util.ArrayList;
import java.util.List;

public class Powerset {
	public static List<List<Integer>> powerset(List<Integer> array) {
		// Write your code here.
		List<Integer> empty = new ArrayList<Integer>();
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list.add(empty);
		for (int i = 0; i < array.size(); i++) {
			int currentNum = array.get(i);
			int len = list.size();
			for (int j = 0; j < len; j++) {
				List<Integer> subList = new ArrayList<Integer>(list.get(j));
				subList.add(currentNum);
				list.add(subList);
			}
		}

		return list;
	}
}

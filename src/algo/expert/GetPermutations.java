package algo.expert;

import java.util.ArrayList;
import java.util.List;

public class GetPermutations {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		// O(N! * N * N) of Time, O(N! * N) of Space
		List<List<Integer>> perms = getPermutations(list);

		for (List<Integer> perm : perms) {
			for (Integer num : perm) {
				System.out.print(num);
			}
			System.out.println();
		}
	}

	public static List<List<Integer>> getPermutations(List<Integer> array) {
		// Write your code here.
		if (array.size() == 0)
			return new ArrayList<List<Integer>>();

		List<List<Integer>> perms = new ArrayList<List<Integer>>();
		getPermutationsHelper(array, new ArrayList<Integer>(), perms);
		// P(3,3) = 3*2*1
		return perms;
	}

	private static void getPermutationsHelper(List<Integer> array, List<Integer> perm, List<List<Integer>> perms) {
		if (array.size() == 0) {
			perms.add(perm);
		} else {
			for (int num : array) {
				List<Integer> newArray = removeNum(num, array);
				List<Integer> newPerm = new ArrayList<Integer>();
				newPerm.addAll(perm);
				newPerm.add(num);
				getPermutationsHelper(newArray, newPerm, perms);
			}
		}

	}

	private static List<Integer> removeNum(int num, List<Integer> array) {
		List<Integer> newArr = new ArrayList<Integer>();
		for (int n : array) {
			if (n != num) {
				newArr.add(n);
			}
		}
		return newArr;
	}
}

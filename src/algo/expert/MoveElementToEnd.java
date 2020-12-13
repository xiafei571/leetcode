package algo.expert;

import java.util.List;

public class MoveElementToEnd {
	public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
		int i = 0;
		int j = array.size() - 1;
		while (i < j) {
			while (i < j && array.get(j) == toMove) {
				j--;
			}
			if (array.get(i) == toMove) {
				swap(array, i, j);
			}
			i++;
		}
		return array;
	}

	public static List<Integer> moveElementToEnd_v1(List<Integer> array, int toMove) {
		for (int i = array.size() - 1; i > 0; i--) {
			if (array.get(i) == toMove)
				continue;

			for (int j = i - 1; j >= 0; j--) {
				if (array.get(j) == toMove) {
					swap(array, i, j);
					break;
				}

				if (j == 0 && array.get(j) != toMove) {
					return array;
				}
			}
		}
		return array;
	}

	private static void swap(List<Integer> array, int i, int j) {
		int temp = array.get(i);
		array.set(i, array.get(j));
		array.set(j, temp);
	}
}

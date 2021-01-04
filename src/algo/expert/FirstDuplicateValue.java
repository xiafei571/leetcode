package algo.expert;

public class FirstDuplicateValue {
	public int firstDuplicateValue(int[] array) {
		// Write your code here.
		int first = -1;

		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] == array[j]) {
					if (first == -1 || j < first)
						first = j;
				}
			}
		}

		return first == -1 ? -1 : array[first];
	}
}

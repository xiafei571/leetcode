package algo.expert;

public class FirstNonRepeatingCharacter {
	public int firstNonRepeatingCharacter(String string) {
		// Write your code here.
		if (null == string || "".equals(string)) {
			return -1;
		}
		String[] array = string.split("");
		for (int i = 0; i < array.length; i++) {
			if (contains(i, array)) {
				continue;
			} else {
				return i;
			}
		}

		return -1;
	}

	private static boolean contains(int target, String[] array) {
		for (int i = 0; i < array.length; i++) {
			if (i != target && array[i].equals(array[target])) {
				return true;
			}
		}
		return false;
	}
}

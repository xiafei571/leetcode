package algo.expert;

public class HasSingleCycle {
	public static boolean hasSingleCycle(int[] array) {
		// Write your code here.
		int len = array.length;
		int currentIdx = 0;
		int step = array[0];
		for (int i = 0; i < len; i++) {
			currentIdx = currentIdx + step;
			if (currentIdx >= len) {
				currentIdx = currentIdx % len;
			} else if (currentIdx < 0) {
				currentIdx = len + currentIdx;
			}

			if (array[currentIdx] == 0) {
				return false;
			} else {
				step = array[currentIdx];
				if (step > len || step < -len) {
					step = step % len;
				}
				array[currentIdx] = 0;
			}
		}

		return true;
	}
}

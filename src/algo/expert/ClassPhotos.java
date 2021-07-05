package algo.expert;

import java.util.ArrayList;
import java.util.Collections;

public class ClassPhotos {
	public boolean classPhotos(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
		// Write your code here.
		Collections.sort(redShirtHeights, Collections.reverseOrder());
		Collections.sort(blueShirtHeights, Collections.reverseOrder());

		String backRow = redShirtHeights.get(0) > blueShirtHeights.get(0) ? "red" : "blue";

		for (int i = 0; i < redShirtHeights.size(); i++) {
			if (backRow.equals("red") && redShirtHeights.get(i) <= blueShirtHeights.get(i)) {
				return false;
			} else if (backRow.equals("blue") && redShirtHeights.get(i) >= blueShirtHeights.get(i)) {
				return false;
			} else {
				continue;
			}
		}
		return true;
	}
}

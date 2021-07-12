package am;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class LoadTheCargo {

	public static void main(String[] args) {
		System.out.println(9 == loadTheCargo(3, new int[] { 3, 1, 2 }, 3, new int[] { 1, 2, 3 }, 4));
	}

	/**
	 * 
	 * @param num, the number of containers
	 * @param containers, the number of containers
	 * @param itemSize, size of itermsPerContainer
	 * @param itemsPerContainer, the number of items packed in each container
	 * @param cargoSize, the number of containers the cargo can carry
	 * @return maximum items
	 */
	private static int loadTheCargo(int num, int[] containers, int itemSize, int[] itemsPerContainer, long cargoSize) {
		// Init sortmap
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>(Collections.reverseOrder());
		for (int i = 0; i < itemSize; i++) {
			// K:items V:containers
			Integer key = itemsPerContainer[i];
			if (map.containsKey(key)) {
				map.put(key, map.get(key) + containers[i]);
			} else {
				map.put(key, containers[i]);
			}
		}

		//Calculate result
		int sum = 0;
		for (Integer k : map.keySet()) {
			if (cargoSize > 0) {
				int cargo = (int) Math.min(map.get(k), cargoSize);
				sum += cargo * k;
				cargoSize -= cargo;
			}else {
				break;
			}
		}
		return sum;
	}
}

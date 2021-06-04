package algo.mock;

import java.util.ArrayList;
import java.util.Collections;

public class SunsetViews {
	
	public static ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
		// Write your code here.
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		int max = 0;
		if (direction.equals("EAST")) {
			for (int i = buildings.length - 1; i >= 0; i--) {
				max = updateMax(buildings, result, max, i);
			}
		}else {
			for (int i = 0; i < buildings.length; i++) {
				max = updateMax(buildings, result, max, i);
			}
		}
		Collections.sort(result);
		return result;
	}

	private static int updateMax(int[] buildings, ArrayList<Integer> result, int max, int idx) {
		if (buildings[idx] > max) {
			result.add(idx);
			max = buildings[idx];
		}
		return max;
	}
	
	public static ArrayList<Integer> sunsetViews2(int[] buildings, String direction) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int idx = 0;
		int step = 1;
		if(direction.equals("EAST")) {
			idx = buildings.length-1;
			step = -1;
		}
		
		int max = 0;
		
		while(idx >=0 && idx < buildings.length) {
			if(buildings[idx] > max) {
				result.add(idx);
				max = buildings[idx];
			}
			 
			idx += step;
		}
		
		if(direction.equals("EAST")) {
			Collections.reverse(result);
		}
		
		return result;
	}

	public static void main(String[] args) {
		ArrayList<Integer> result = sunsetViews2(new int[] { 3, 5, 4, 4, 3, 1, 3, 2 }, "EAST");
		for (Integer i : result) {
			System.out.println(i);
		}
	}

}

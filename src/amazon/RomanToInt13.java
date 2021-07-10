package amazon;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt13 {
	public int romanToInt(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int result = 0;

		for (int i = 0; i < s.length(); i++) {
			int value = map.get(s.charAt(i));
			if (i < s.length() - 1 && value < map.get(s.charAt(i + 1))) {
				result -= value;
			} else {
				result += value;
			}
		}

		return result;
	}
}

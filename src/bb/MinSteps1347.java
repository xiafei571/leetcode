package bb;

public class MinSteps1347 {
	public int minSteps(String s, String t) {
		int steps = 0;
		int[] chars = new int[26];
		int len_s = s.length();
		for (int i = 0; i < len_s; i++) {
			chars[s.charAt(i) - 'a']++;
			chars[t.charAt(i) - 'a']--;
		}

		for (int i = 0; i < chars.length; i++) {
			steps += (chars[i] > 0 ? chars[i] : 0 - chars[i]);
		}

		return steps / 2;
	}
}

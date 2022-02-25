package bb;

public class IsAnagram242 {
	public boolean isAnagram(String s, String t) {

		if (s == null || t == null) {
			return false;
		}

		int len_s = s.length();

		if (len_s != t.length()) {
			return false;
		}

		int[] chars = new int[26];

		for (int i = 0; i < len_s; i++) {
			chars[s.charAt(i) - 'a']++;
			chars[t.charAt(i) - 'a']--;
		}

		for (int i = 0; i < chars.length; i++) {
			if (chars[i] != 0) {
				return false;
			}
		}

		return true;

	}
}

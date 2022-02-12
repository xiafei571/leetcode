package am;

public class MinFlipsMonoIncr926 {
	public int minFlipsMonoIncr(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int flip = 0;
		int cnt_1 = 0;

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '1') {
				cnt_1++;
			} else {
				flip = Math.min(flip + 1, cnt_1);
			}
		}

		return flip;

	}
}

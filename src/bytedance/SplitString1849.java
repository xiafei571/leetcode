package bytedance;

public class SplitString1849 {
	public boolean splitString(String s) {
		long num = 0;
		for (int len = 1; len < s.length(); len++) {
			// long num = Long.valueOf(s.substring(0, len));
			num = num * 10 + (s.charAt(len - 1) - '0');
			if (num >= 10000000000L) {
				break;
			}
			if (dfs(s, len, num)) {
				return true;
			}
		}

		return false;
	}

	private boolean dfs(String s, int cur, long preNum) {
		if (cur == s.length()) {
			return true;
		}
		long curNum = 0;
		for (int len = 1; cur + len <= s.length(); len++) {
			// long curNum = Long.valueOf(s.substring(cur, cur+len));
			curNum = curNum * 10 + (s.charAt(cur + len - 1) - '0');
			if (curNum >= 10000000000L) {
				break;
			}
			if (preNum - 1 == curNum && dfs(s, cur + len, curNum)) {
				return true;
			}
		}

		return false;
	}
}

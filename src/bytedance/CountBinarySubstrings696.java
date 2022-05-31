package bytedance;

public class CountBinarySubstrings696 {
	public int countBinarySubstrings(String s) {
		// if(s == null || s.length() <= 1){
		// return 0;
		// }
		int curr = 1;
		int pre = 0;
		int count = 0;

		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == s.charAt(i - 1)) {
				curr++;
			} else {
				count += Math.min(pre, curr);
				pre = curr;
				curr = 1;
			}
		}

		return count += Math.min(pre, curr);
	}
}

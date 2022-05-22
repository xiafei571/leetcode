package bytedance;

public class BullsandCows299 {
	public String getHint(String secret, String guess) {
		// 1 2 3 1
		// 0 1 1 1
		int bulls = 0;
		int cows = 0;
		// [-1, -1, 1, 1]
		int[] h = new int[10];
		for (int i = 0; i < guess.length(); i++) {
			char s = secret.charAt(i);
			char g = guess.charAt(i);
			if (s == g) {
				bulls++;
			} else {
				if (h[s - '0'] < 0) {
					cows++;
				}
				if (h[g - '0'] > 0) {
					cows++;
				}
				h[s - '0']++;
				h[g - '0']--;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(bulls);
		sb.append("A");
		sb.append(cows);
		sb.append("B");
		return sb.toString();
	}
}

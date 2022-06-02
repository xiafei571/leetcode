package bytedance;

public class IsAlienSorted953 {
	public boolean isAlienSorted(String[] words, String order) {

		for (int i = 0; i < order.length(); i++) {
			char ch = order.charAt(i);
			setSeq(ch, i);
		}

		for (int i = 0; i < words.length - 1; i++) {
			String a = words[i];
			String b = words[i + 1];
			if (!compare(a, b)) {
				return false;
			}
		}

		return true;
	}

	private static int charSeq[] = new int[26];

	private int getSeq(char ch) {
		return charSeq[ch - 'a'];
	}

	private void setSeq(char ch, int seq) {
		charSeq[ch - 'a'] = seq;
	}

	private boolean compare(String a, String b) {

		for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
			char c1 = a.charAt(i);
			char c2 = b.charAt(i);
			// the first different letter
			if (c1 != c2) {
				// if(getSeq(c1) > getSeq(c2)){
				// return false;
				// }else{ // case: ["kuvp","q"] "ngxlkthsjuoqcpavbfdermiywz"
				// return true;
				// }
				return getSeq(c1) <= getSeq(c2);
			}
		}

		if (a.length() > b.length()) {// case: ["apple","app"] "abcdefghijklmnopqrstuvwxyz"
			return false;
		}

		return true;
	}
}

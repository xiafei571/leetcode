package am;

public class IsAlienSorted {

	public static void main(String[] args) {
		System.out.println("a".compareTo("b"));
		System.out.println("abb".compareTo("abc"));
		System.out.println("hello".compareTo("leetcode"));
		System.out.println("kuvp".compareTo("q"));
		/*
		 * ["kuvp","q"]
"ngxlkthsjuoqcpavbfdermiywz"

["hello","leetcode"]
"hlabcdefgijkmnopqrstuvwxyz"
		 */
		System.out.println(isAlienSorted(new String[] { "hello", "leetcode" }, "hlabcdefgijkmnopqrstuvwxyz"));
		System.out.println(isAlienSorted(new String[] { "kuvp", "q" }, "ngxlkthsjuoqcpavbfdermiywz"));
	}

	public static boolean isAlienSorted(String[] words, String order) {
		char[] dict = order.toCharArray();
		for (int i = 0; i < order.length(); i++) {//O(1)
			char ch = order.charAt(i);
			dict[ch-'a'] = (char)('a'+i);
		}

		String pre = words[0];

		for (int i = 1; i < words.length; i++) {//O(N*C) C is max length of word
			String curr = words[i];
			int c = compare(dict, pre, curr);
			if (c > 0) {
				return false;
			}

			pre = curr;
		}
		return true;

	}

	private static int compare(char[] dict, String str1, String str2) {
		String new1 = "";
		String new2 = "";
		for (int i = 0; i < str1.length(); i++) {
			new1 += dict[str1.charAt(i) - 'a'];
		}

		for (int i = 0; i < str2.length(); i++) {
			new2 += dict[str2.charAt(i) - 'a'];
		}

		return new1.compareTo(new2);
	}
}

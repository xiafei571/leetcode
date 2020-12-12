package algo.expert;

public class CaesarCypherEncryptor {
	public static String caesarCypherEncryptor(String str, int key) {
		key = key % 26;
		char[] newChar = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			newChar[i] = getNewChar(str.charAt(i), key);
		}
		return new String(newChar);
	}

	private static char getNewChar(char c, int key) {
		int new_code = c + key;
		return new_code <= 122 ? (char) new_code : (char) (96 + new_code % 122);
	}
}

package am;

public class RemoveDigit2259 {
	public String removeDigit(String number, char digit) {
		int removeIdx = 0;

		for (int i = 0; i < number.length(); i++) {
			char cur = number.charAt(i);
			if (cur == digit) {
				removeIdx = i;
				if (i + 1 < number.length() && number.charAt(i) < number.charAt(i + 1)) {
					break;
				}
			}
		}

		return number.substring(0, removeIdx) + number.substring(removeIdx + 1, number.length());
	}
}

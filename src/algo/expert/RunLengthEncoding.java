package algo.expert;

public class RunLengthEncoding {

	public String runLengthEncoding(String string) {
		if (string.length() == 0) {
			return "";
		}

		if (string.length() == 1) {
			return "1" + string;
		}

		String result = "";
		char first = string.charAt(0);
		for (int i = 1; i < string.length(); i++) {
			if (string.charAt(i) - first != 0 || i >= 9) {
				result += Integer.toString(i) + first;
				return result + runLengthEncoding(string.substring(i));
			} else if (i == string.length() - 1) {
				result += Integer.toString(i + 1) + first;
				return result;
			}
		}
		return result;
	}
}

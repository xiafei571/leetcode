package algo.expert;

public class GlobMatching {

	public static boolean globMatching(String fileName, String pattern) {
		// Write your code here.
		// abcdabcdefg
		// ab*defg

		if (fileName == "" || fileName.length() == 0) {
			for (int i = 0; i < pattern.length(); i++) {
				if (pattern.charAt(i) != '*') {
					return false;
				}
			}
			return true;
		}
		int f = 0;
		int p = 0;
		while (f < fileName.length() && p < pattern.length()) {

			if ((f == fileName.length() - 1 || fileName == "") && p == pattern.length() - 1) {
				return fileName.charAt(f) == pattern.charAt(p) || pattern.charAt(p) == '*' || pattern.charAt(p) == '?';
			}

			if (pattern.charAt(p) == '*') {
				if (p == pattern.length() - 1) {
					return true;
				} else if (fileName == "") {
					p++;
				} else {
					for (int i = fileName.length() - 1; i >= f; i--) {
						if ((fileName.charAt(i) == pattern.charAt(p + 1) || pattern.charAt(p + 1) == '*'
								|| pattern.charAt(p + 1) == '?')
								&& globMatching(fileName.substring(i, fileName.length()),
										pattern.substring(p + 1, pattern.length()))) {
							return true;
						}
					}
					return false;
				}

			} else if (pattern.charAt(p) == '?') {
				f++;
				p++;
			} else {
				if (pattern.charAt(p) == fileName.charAt(f)) {
					f++;
					p++;
				} else {
					return false;
				}
			}
		}

		return false;
	}

}

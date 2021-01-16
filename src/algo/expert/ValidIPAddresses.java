package algo.expert;

import java.util.ArrayList;

public class ValidIPAddresses {
	
	//O(1) of time O(1) of space
	public ArrayList<String> validIPAddresses(String string) {
		// Write your code here.
		if (string.length() < 4) {
			return new ArrayList<String>();
		}
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 1; i < 4; i++) {
			String s1 = string.substring(0, i);
			if (notValidStr(s1)) {
				continue;
			}
			for (int j = i + 1; j < i + 4 && j < string.length(); j++) {
				String s2 = string.substring(i, j);
				if (notValidStr(s2)) {
					continue;
				}
				for (int k = j + 1; k < j + 4 && k < string.length(); k++) {
					String s3 = string.substring(j, k);
					String s4 = string.substring(k, string.length());
					if (validStr(s3) && validStr(s4)) {
						list.add(s1 + "." + s2 + "." + s3 + "." + s4);
					} else {
						continue;
					}
				}
			}

		}
		return list;
	}

	private static boolean notValidStr(String string) {
		return !validStr(string);
	}

	private static boolean validStr(String string) {
		if (string == null || string.equals("")) {
			return false;
		}

		if (string.length() >= 2 && string.startsWith("0")) {
			return false;
		}

		int num = Integer.valueOf(string);
		return num >= 0 && num <= 255;
	}
}

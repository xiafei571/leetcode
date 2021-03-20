package algo.expert;

public class GenerateDocument {
	public boolean generateDocument(String characters, String document) {
		// Write your code here.

		if ("".equals(document)) {
			return true;
		}

		String[] c_arr = characters.split("");
		String[] d_arr = document.split("");

		if (c_arr.length < d_arr.length) {
			return false;
		}

		for (int i = 0; i < d_arr.length; i++) {
			boolean find = false;
			for (int j = i; j < c_arr.length; j++) {
				if (d_arr[i].equals(c_arr[j])) {
					find = true;
					String temp = c_arr[i];
					c_arr[i] = c_arr[j];
					c_arr[j] = temp;
					break;
				}
			}
			if (!find) {
				return false;
			}
		}
		return true;
	}
}

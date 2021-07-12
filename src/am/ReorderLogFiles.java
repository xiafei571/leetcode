package am;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ReorderLogFiles {
	public static String[] reorderLogFiles(String[] logs) {
		Arrays.sort(logs, new Comparator<String>() {
			@Override
			public int compare(String log1, String log2) {
				String[] strs1 = log1.split(" ", 2);
				String[] strs2 = log2.split(" ", 2);

				boolean isword1 = isWord(strs1[1].charAt(0));
				boolean isword2 = isWord(strs2[1].charAt(0));

				if (isword1 && isword2) {
					int eq = strs1[1].compareTo(strs2[1]);
					if (eq == 0) {
						return strs1[0].compareTo(strs1[1]);
					}
					return eq;
				}

				if (isword1 && !isword2) {
					return 1;
				} else if (!isword1 && isword2) {
					return -1;
				} else {
					return 0;
				}
			}

		});

		return logs;
	}

	/*
	 * 所有 字母日志 都排在 数字日志 之前。 字母日志 在内容不同时，忽略标识符后，按内容字母顺序排序； 在内容相同时，按标识符排序。
	 * 数字日志应该保留原来的相对顺序。
	 */

	private static boolean isWord(char c) {
		return c >= 'a' && c <= 'z';
	}
}

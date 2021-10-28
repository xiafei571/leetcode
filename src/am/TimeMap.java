package am;

import java.util.HashMap;
import java.util.Map;

/**
 * lc 981
 *
 */
public class TimeMap {
	private Map<String, Map<Integer, String>> keyMap;

	public TimeMap() {
		keyMap = new HashMap<String, Map<Integer, String>>();
	}

	public void set(String key, String value, int timestamp) {
		Map<Integer, String> timeMap = keyMap.getOrDefault(key, new HashMap<Integer, String>());
		timeMap.put(timestamp, value);
		keyMap.put(key, timeMap);
	}

	public String get(String key, int timestamp) {
		Map<Integer, String> timeMap = keyMap.getOrDefault(key, new HashMap<Integer, String>());
		if (timeMap.size() == 0) {
			return "";
		}

		String value = timeMap.get(timestamp);
		while (value == null) {
			value = timeMap.get(--timestamp);
		}

		return value == null ? "" : value;
	}

	public static void main(String[] args) {
		TimeMap timeMap = new TimeMap();
		timeMap.set("foo", "bar", 1); // 存储键 "foo" 和值 "bar" ，时间戳 timestamp = 1  
		System.out.println(timeMap.get("foo", 1));// 返回 "bar"

		System.out.println(timeMap.get("foo", 3)); // 返回 "bar", 因为在时间戳 3 和时间戳 2 处没有对应 "foo" 的值，所以唯一的值位于时间戳 1 处（即 "bar"）
													// 。
		timeMap.set("foo", "bar2", 4); // 存储键 "foo" 和值 "bar2" ，时间戳 timestamp = 4 
		System.out.println(timeMap.get("foo", 4)); // 返回 "bar2"
		System.out.println(timeMap.get("foo", 5)); // 返回 "bar2"

	}
}

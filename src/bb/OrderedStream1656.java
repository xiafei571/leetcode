package bb;

import java.util.ArrayList;
import java.util.List;

public class OrderedStream1656 {
	private String[] orders;
	int curId;

	public OrderedStream1656(int n) {
		orders = new String[n + 1];
		curId = 1;
	}

	public List<String> insert(int idKey, String value) {
		List<String> result = new ArrayList<String>();
		orders[idKey] = value;
		while (curId < orders.length && orders[curId] != null) {
			result.add(orders[curId++]);
		}
		return result;
	}
}

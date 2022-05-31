package bytedance;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CalcEquation399 {
	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		Map<String, Map<String, Double>> g = new HashMap<>();
		buildGraph(g, equations, values);

		double[] res = new double[queries.size()];
		Arrays.fill(res, -1);

		for (int i = 0; i < queries.size(); i++) {
			List<String> query = queries.get(i);
			String a = query.get(0);
			String b = query.get(1);

			if (!g.containsKey(a) || !g.containsKey(b)) {
				continue;
			}

			dfs(g, a, b, new HashSet<String>(), 1.0, i, res);
		}

		return res;
	}

	private void dfs(Map<String, Map<String, Double>> g, String a, String b, Set<String> visted, double d, int idx,
			double[] res) {
		visted.add(a);
		Map<String, Double> aMap = g.get(a);
		if (aMap == null || aMap.size() == 0) {
			return;
		}

		if (aMap.containsKey(b)) {
			res[idx] = aMap.get(b) * d;
			return;
		}

		for (String next : aMap.keySet()) {
			if (visted.contains(next)) {
				continue;
			}

			dfs(g, next, b, visted, aMap.get(next) * d, idx, res);
		}
	}

	private void buildGraph(Map<String, Map<String, Double>> g, List<List<String>> equations, double[] values) {
		for (int i = 0; i < equations.size(); i++) {
			List<String> equation = equations.get(i);
			String a = equation.get(0);
			String b = equation.get(1);

			Map<String, Double> aMap = g.getOrDefault(a, new HashMap<String, Double>());
			Map<String, Double> bMap = g.getOrDefault(b, new HashMap<String, Double>());
			aMap.put(b, values[i]);
			bMap.put(a, 1.0 / values[i]);

			g.put(a, aMap);
			g.put(b, bMap);
		}
	}
}

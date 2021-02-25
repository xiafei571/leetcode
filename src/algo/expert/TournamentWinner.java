package algo.expert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TournamentWinner {

	public String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
		// Write your code here.
		Map<String, Integer> resultMap = new HashMap<String, Integer>();
		for (int i = 0; i < competitions.size(); i++) {
			ArrayList<String> competition = competitions.get(i);
			updateResultMap(resultMap, competition.get(0), competition.get(1), results.get(i));
		}

		return findWinner(resultMap);
	}

	private static String findWinner(Map<String, Integer> resultMap) {
		int maxScore = 0;
		String winner = "";
		for (String k : resultMap.keySet()) {
			if (resultMap.get(k) > maxScore) {
				maxScore = resultMap.get(k);
				winner = k;
			}
		}
		return winner;
	}

	private static void updateResultMap(Map<String, Integer> resultMap, String home, String away, Integer result) {
		if (result == 1) {
			if (resultMap.containsKey(home)) {
				resultMap.put(home, resultMap.get(home) + 3);
			} else {
				resultMap.put(home, 3);
			}
		} else if (result == 0) {
			if (resultMap.containsKey(away)) {
				resultMap.put(away, resultMap.get(away) + 3);
			} else {
				resultMap.put(away, 3);
			}
		}
	}
}

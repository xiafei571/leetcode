package bb;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Leaderboard {
	Map<Integer, Integer> scores;

	public Leaderboard() {
		scores = new HashMap<Integer, Integer>();
	}

	public void addScore(int playerId, int score) {
		if (scores.containsKey(playerId)) {
			int currScore = scores.get(playerId);
			currScore += score;
			scores.put(playerId, currScore);
		} else {
			scores.put(playerId, score);
		}
	}

	public int top(int K) {
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a, b) -> b - a);
		for (Integer key : scores.keySet()) {
			heap.offer(scores.get(key));
		}

		int sum = 0;
		while (K > 0 && !heap.isEmpty()) {
			sum += heap.poll();
			K--;
		}
		return sum;
	}

	public void reset(int playerId) {
		if (scores.containsKey(playerId)) {
			scores.remove(playerId);
		}
	}
}

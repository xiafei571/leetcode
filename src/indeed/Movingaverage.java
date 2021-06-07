package indeed;

import java.util.LinkedList;
import java.util.Queue;

public class Movingaverage {
	/*
	 * Given a stream of input, and a API int getNow() to get the current time
	 * stamp, Finish two methods:
	 * 
	 * 1. void record(int val) to save the record. 2. double getAvg() to calculate
	 * the averaged value of all the records in 5 minutes.
	 * 
	 * Solution: Maintain a sliding window (queue) which stores the elements in 5
	 * minutes. Also maintain the sum of the records in the window.
	 * 
	 * For the record(), add an event into the queue. Remove all expired events from
	 * the queue. For the getAvg(), first remove the expired events from the queue,
	 * and then calculate the average.
	 * 
	 */
	class Event {
		int timestamp;
		int val;

		public Event(int timestamp, int val) {
			this.timestamp = timestamp;
			this.val = val;
		}
	}

	private Queue<Event> queue = new LinkedList<Event>();
	private int sum = 0;

	private int getNow() {
		return (int) (System.currentTimeMillis() / (1000 * 60));
	}

	public void record(int val) {
		queue.offer(new Event(getNow(), val));
		sum += val;
		removeExpired();
	}

	private boolean expired(int currentTime, int eventTime) {
		return currentTime - eventTime > 5;
	}

	private void removeExpired() {
		while (!queue.isEmpty() && expired(getNow(), queue.peek().timestamp)) {
			Event event = queue.poll();
			sum -= event.val;
		}
	}

	private double getAvg() {
		removeExpired();
		if (queue.size() == 0) {
			return 0;
		}
		return sum / queue.size();
	}
}

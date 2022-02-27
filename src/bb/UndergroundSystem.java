package bb;

import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem {//1396. Design Underground System
	Map<Integer, Event> arrivals;
	Map<String, Double[]> averages;

	public UndergroundSystem() {
		arrivals = new HashMap<Integer, Event>();
		averages = new HashMap<String, Double[]>();
	}

	public void checkIn(int id, String stationName, int t) {
		arrivals.put(id, new Event(id, stationName, t));
	}

	public void checkOut(int id, String stationName, int t) {
		Event checkInEvent = arrivals.get(id);
		arrivals.remove(id);

		String key = getKey(checkInEvent.stationName, stationName);
		Double[] record = averages.getOrDefault(key, new Double[] { 0.0, 0.0 });
		record[0] += t - checkInEvent.time;
		record[1]++;
		averages.put(key, record);
	}

	public double getAverageTime(String startStation, String endStation) {
		String key = getKey(startStation, endStation);
		if (averages.containsKey(key)) {
			Double[] record = averages.get(key);
			return record[0] / record[1];
		} else {
			return 0;
		}
	}

	private static String getKey(String startStation, String endStation) {
		return startStation + "_" + endStation;
	}

	class Event {
		int id;
		String stationName;
		int time;

		public Event(int id, String stationName, int time) {
			this.id = id;
			this.stationName = stationName;
			this.time = time;
		}
	}
}

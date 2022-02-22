package am;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankTeams1366 {
	public String rankTeams(String[] votes) {
		if (votes == null || votes.length == 0) {
			return null;
		}

		if (votes.length == 1) {
			return votes[0];
		}
		// votes = ["ABC","ACB","ABC","ACB","ACB"]
		// A:[5,0,0] B:[0,2,3] C:[0,3,2]
		// save to map
		Map<String, VoteRecord> map = new HashMap<String, VoteRecord>();
		for (String vote : votes) {
			for (int i = 0; i < vote.length(); i++) {
				String team = String.valueOf(vote.charAt(i));
				VoteRecord record = map.getOrDefault(team, new VoteRecord(team, vote.length()));
				record.ranks[i]++;
				map.put(team, record);
			}
		}
		// sort in list
		List<VoteRecord> list = new ArrayList<>(map.values());
		Collections.sort(list, new Comparator<VoteRecord>() {
			@Override
			public int compare(VoteRecord o1, VoteRecord o2) {
				int idx = 0;
				while (idx < o1.ranks.length && idx < o2.ranks.length) {
					if (o1.ranks[idx] == o2.ranks[idx]) {
						idx++;
					} else {
						return o2.ranks[idx] - o1.ranks[idx];
					}
				}

				return o1.team.compareTo(o2.team);
			}
		});
		// build result
		StringBuilder res = new StringBuilder();
		for (VoteRecord record : list) {
			res.append(record.team);
		}

		return res.toString();
	}

	class VoteRecord {
		String team;
		int[] ranks;

		public VoteRecord(String team, int teamCount) {
			this.team = team;
			this.ranks = new int[teamCount];
		}
	}
}

package am;

public class IsRobotBounded {
	public boolean isRobotBounded(String instructions) {
		int x = 0;
		int y = 0;
		// N E S W
		int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
		int curr = 0;

		for (int i = 0; i < instructions.length(); i++) {
			char act = instructions.charAt(i);

			if (act == 'G') {
				x += dirs[curr % 4][0];
				y += dirs[curr % 4][1];
			} else if (act == 'L') {
				curr = (curr + 3) % 4;
			} else if (act == 'R') {
				curr = (curr + 1) % 4;
			} else {// wrong input
				return false;
			}
		}

		return (x == 0 && y == 0) || curr % 4 != 0;
	}
}

package amazon;

public class CountLevelUpPlayers {
	public static void main(String[] args) {
		System.out.println(2 == cutOffRank(2, 5, new int[] { 100, 90, 80, 70, 60 }));
		System.out.println(4 == cutOffRank(4, 5, new int[] { 100, 100, 80, 70, 60 }));
		System.out.println(3 == cutOffRank(3, 4, new int[] { 100, 50, 50, 25 }));
		System.out.println(5 == cutOffRank(4, 5, new int[] { 2, 2, 3, 4, 5 }));
	}

	private static int cutOffRank(int cutOffRank, int num, int[] scores) {
		int[] numbers = new int[101];
		int maxScore = 0;

		for (int score : scores) {
			numbers[score] += 1;
			if (score > maxScore) {
				maxScore = score;
			}
		}

		int total = 0;

		while (total < cutOffRank) {
			total += numbers[maxScore];
			maxScore--;
		}

		return total;
	}
}

package hackerrank.array;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HourglassSum {
	// Complete the hourglassSum function below.
	static int hourglassSum(int[][] arr) {
		List<Integer[]> hourglasses = new ArrayList<Integer[]>();
		hourglasses.add(new Integer[] { 0, 0 });
		hourglasses.add(new Integer[] { 0, 1 });
		hourglasses.add(new Integer[] { 0, 2 });
		hourglasses.add(new Integer[] { 1, 1 });
		hourglasses.add(new Integer[] { 2, 0 });
		hourglasses.add(new Integer[] { 2, 1 });
		hourglasses.add(new Integer[] { 2, 2 });
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				// i,j
				int sum = 0;
				for (Integer[] val : hourglasses) {
					sum += arr[i + val[0]][j + val[1]];
				}
				max = Math.max(max, sum);
			}
		}
		return max;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int[][] arr = new int[6][6];

		for (int i = 0; i < 6; i++) {
			String[] arrRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 6; j++) {
				int arrItem = Integer.parseInt(arrRowItems[j]);
				arr[i][j] = arrItem;
			}
		}

		int result = hourglassSum(arr);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}

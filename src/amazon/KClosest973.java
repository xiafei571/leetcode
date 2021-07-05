package amazon;

public class KClosest973 {
	
	public static void main(String[] args) {
		int [][] points = {{1,3},{-2,2}};
		int k = 1;
		int[][] res = kClosest(points, k);
		for(int i = 0; i < res.length;i++) {
			System.out.println(res[i][0]+" "+res[i][1]);
		}
	}

	public static int[][] kClosest(int[][] points, int k) {
		int[][] res = new int[k][2];
		quickSelect(points, 0, points.length-1, k - 1);
		for (int i = 0; i < k; i++) {
			res[i] = points[i];
		}

		return res;
	}

	private static void quickSelect(int[][] points, int left, int right, int k) {
		int p = partition(points, left, right);
		if (p == k) {
			return;
		} else if (p > k) {
			quickSelect(points, left, p - 1, k);
		} else {
			quickSelect(points, p + 1, right, k);
		}
	}

	private static int partition(int[][] points, int left, int right) {
		double dis = distance(points[right]);
		int i = left;
		for (int j = left; j < right; j++) {
			if (distance(points[j]) < dis) {
				swap(points, i, j);
				i++;
			}
		}
		swap(points, i, right);
		return i;
	}

	private static double distance(int[] point) {
		return Math.sqrt(point[0] * point[0] + point[1] * point[1]);
	}

	private static void swap(int[][] points, int i, int j) {
		int[] temp = points[i];
		points[i] = points[j];
		points[j] = temp;
	}

}

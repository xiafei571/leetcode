package am;

public class FinalInstances {

	public static void main(String[] args) {
		System.out.println(finalInstances(1, new int[] { 5, 10, 80 }));
		System.out.println(finalInstances(5, new int[] { 30, 5, 4, 8, 19, 89 }));
	}

	private static int finalInstances(int instances, int[] averageUtil) {
		int max_instance = (int) (2 * Math.pow(10, 8));
		int curr_instance = instances;
		int i = 0;
		while (i < averageUtil.length) {
			int util = averageUtil[i];
			if (util < 25 && curr_instance > 1) {
				curr_instance = (curr_instance+1) / 2;
				i += 11;
			} else if (util > 60 && util <= max_instance) {
				curr_instance = curr_instance * 2;
				i += 11;
			} else {
				i++;
			}
		}
		return curr_instance;
	}

}

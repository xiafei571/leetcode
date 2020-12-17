package algo.expert;

public class ArrayOfProducts {
	public int[] arrayOfProducts(int[] array) {
		int[] result = new int[array.length];
		for (int i = 0; i < result.length; i++) {
			int sum = 1;
			for (int j = 0; j < array.length; j++) {
				if (j != i)
					sum = sum * array[j];
			}
			result[i] = sum;
		}
		return result;
	}
}

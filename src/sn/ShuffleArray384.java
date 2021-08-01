package sn;

import java.util.Random;

public class ShuffleArray384 {

	int[] array;
	int[] original;

	public ShuffleArray384(int[] nums) {
		original = nums;
		array = original.clone();
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		array = original.clone();
		return array;
	}

	/** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			int r = random.nextInt(array.length - i) + i;
			swap(array, i, r);
		}
		return array;
    }

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}

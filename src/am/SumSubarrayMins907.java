package am;

import java.util.Stack;

public class SumSubarrayMins907 {
	public static void main(String[] args) {
		System.out.println(sumSubarrayMins1(new int[] { 71, 55, 82, 55 }));
	}

	public int sumSubarrayMins(int[] arr) {

		int mod = (int) 1e9 + 7;
		long sum = 0l;

		Stack<Integer> stack = new Stack<Integer>();
		int[] left = new int[arr.length];
		int[] right = new int[arr.length];
		// orinal A[] [3,1,2,4]
		// left[] + 1 = [1,2,1,1] the number of subarray ending with A[i],
		// right[] + 1 = [1,3,2,1] the number of subarray starting with A[i],
		for (int i = 0; i < arr.length; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				left[i] = i + 1;
			} else {
				left[i] = i - stack.peek();
			}
			stack.add(i);
		}
		// printArr(left);

		stack = new Stack<Integer>();
		for (int i = arr.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				right[i] = arr.length - i;
			} else {
				right[i] = stack.peek() - i;
			}
			stack.add(i);
		}
		// printArr(right);

		// res = sum(A[i] * f[i])
		// f[i] = (left[i] + 1) * (right[i] + 1)
		for (int i = 0; i < arr.length; i++) {
			sum = (long) (sum + (long) arr[i] * left[i] * right[i]);
		}
		return (int) (sum % mod);
	}

	public static int sumSubarrayMins1(int[] A) {
		long res = 0, mod = (int) 1e9 + 7;
		int n = A.length, left[] = new int[n], right[] = new int[n];
		Stack<int[]> s1 = new Stack<>(), s2 = new Stack<>();
		for (int i = 0; i < n; ++i) {
			int count = 1;
			while (!s1.isEmpty() && s1.peek()[0] > A[i])
				count += s1.pop()[1];
			s1.push(new int[] { A[i], count });
			left[i] = count;
		}
		printArr(left);
		for (int i = n - 1; i >= 0; --i) {
			int count = 1;
			while (!s2.isEmpty() && s2.peek()[0] >= A[i])
				count += s2.pop()[1];
			s2.push(new int[] { A[i], count });
			right[i] = count;
		}
		printArr(right);
		for (int i = 0; i < n; ++i)
			res = (res + (long) A[i] * left[i] * right[i]) % mod;
		return (int) res;
	}

	private static void printArr(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}
}

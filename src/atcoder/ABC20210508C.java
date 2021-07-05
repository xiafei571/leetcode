package atcoder;

import java.util.Scanner;

public class ABC20210508C {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer N = sc.nextInt();
		sc.nextLine();
		String line = sc.nextLine();
		String[] arr = line.split(" ");
		long pairs = 0;
		
		long[] ss = new long[200];
		
//		for(int i = 0; i < N-1; i++) {
//			for(int j = i+1; j < N; j++) {
//				if((Long.valueOf(arr[j]) % 200 - Long.valueOf(arr[i]) % 200)== 0) {
//					pairs++;
//				}
//			}
//		}
		for(int i = 0; i < N; i++) {
			int num = (Integer.valueOf(arr[i]) % 200);
			ss[num]++;
		}
		
		for(long s : ss) {
			pairs += (s * (s-1))/2;
		}
		
		System.out.println(pairs);
		
	}

}

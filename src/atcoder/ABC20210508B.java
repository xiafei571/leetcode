package atcoder;

import java.util.Scanner;

public class ABC20210508B {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Long N = sc.nextLong();
		Long K = sc.nextLong();
		
		while(K > 0) {
			if(N % 200 == 0) {
				N = N / 200;
			}else {
//				N = Integer.valueOf(String.valueOf(N) + "200");
				N = N * 1000 + 200;
			}
			K--;
		}
		
		System.out.println(N);
	}
}

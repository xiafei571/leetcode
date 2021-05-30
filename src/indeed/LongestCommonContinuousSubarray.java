package indeed;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonContinuousSubarray {

	public static List<String> longestCommonContinuousHistory(String[] s1, String[] s2){
		List<String> result = new ArrayList<String>();
		int[][] dp = new int[s1.length+1][s2.length+1];
		//dp[i][j] means max_common(s1[i:] s2[j:])
		//dp[i][j] depands on s1[i]s2[j] and dp[i+1] dp[j+1]
		int max = 0;
		int max_idx = -1;
		for(int i = s1.length - 1; i>=0 ; i--) {
			for(int j = s2.length - 1; j >=0; j--) {
				if(s1[i].equals(s2[j])) {
					dp[i][j] = dp[i+1][j+1] + 1;
					if(dp[i][j] > max) {
						max = dp[i][j];
						max_idx = i;
					}
				}
			}
		}
		
		if(max != 0) {
			for(int i = max_idx; i < max_idx + max; i++) {
				result.add(s1[i]);
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		String[] history1 = {"3234.html", "xys.html", "7hsaa.html"};
		String[] history2 = {"3234.html", "sdhsfjdsh.html", "xys.html", "7hsaa.html"};
		List<String> result = longestCommonContinuousHistory(history1,history2);
		//"xys.html", "7hsaa.html"
		//abc
		//adbc
		for(String s : result) {
			System.out.println(s);
		}
	}
}

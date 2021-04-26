package leetcode;

public class LongestPalindrome {
	public static void main(String[] args) {
//		System.out.println(longestPalindrome("cbbd"));
		System.out.println(longestPalindrome("babad"));
		System.out.println(longestPalindrome2("babad"));
	}
	
	private static String longestPalindrome2(String s) { // N^2
        int begin = 0;
        int longest = 1;
        if(s.length() == 1){
            return s;
        }

        int[][] dp = new int[s.length()][s.length()];

        for(int i = 0; i < s.length(); i++){
            dp[i][i] = 1;
        }
        //j-i >= 3 : dp[i][j] = dp[i+1][j-1] && s[i] == s[j]
        //j-i < 3 : s[i] == s[j]
        for(int j = 1; j < s.length(); j++){
            for(int i = 0; i < j + 1; i++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j - i < 3){
                        dp[i][j] = 1;
                    }else{
                        if(dp[i+1][j-1] == 1){
                            dp[i][j] = 1;
                        }
                    }
                }else{
                    continue;
                }

                if(dp[i][j] == 1 && j - i + 1 > longest){
                    begin = i;
                    longest = j - i + 1;
                }
            }
        }

        return s.substring(begin, begin+longest);
    }

	public static String longestPalindrome(String s) {//N^3
		if (isPalindrome(s)) {
			return s;
		}

		int lens = s.length() - 1;
		while (lens > 0) {
			for (int i = 0; i + lens <= s.length(); i++) {
				String lst = s.substring(i, i + lens);
				if (isPalindrome(lst)) {
					return lst;
				}
			}
			lens--;
		}
		return null;
	}

	private static boolean isPalindrome(String s) {
		if(s.length() == 1) {
			return true;
		}
		
		int left = 0;
		int right = s.length() - 1;
		while(left < right) {
			if(s.charAt(left) != s.charAt(right)) {
				return false;
			}
			right--;
			left++;
		}
		return true;
	}
}

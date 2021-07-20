package am;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<String>(wordDict);
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        for(int i = 1; i < s.length() + 1; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] == 1 && set.contains(s.substring(j, i))){
                    dp[i] = 1;
                }
            }
        }
        
        return dp[s.length()] == 1;
    }
}

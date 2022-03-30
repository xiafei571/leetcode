package kt;

public class LCS {
	 public int findLength(int[] nums1, int[] nums2) {
         int subIndex = 0;
         int subSize = 0;
         int[][] dp = new int[nums1.length+1][nums2.length+1];
         for(int i = 1; i < dp.length; i++){
             for(int j = 1; j < dp[0].length; j++){
                 if(nums1[i-1] == nums2[j-1]){
                     dp[i][j] = dp[i-1][j-1] + 1;
                     // System.out.println(i+","+j+" "+dp[i][j]);
                     if(dp[i][j] > subSize){
                         subSize = dp[i][j];
                         subIndex = i-1;
                     }
                 }
             }
         }
         //[subIndex-subSize : subIndex]
         System.out.println(subIndex);
         return subSize;
     }
   
   public int findLength2(int[] nums1, int[] nums2) {
       int subIndex = 0;
       int subSize = 0;
       
       for(int i = 0; i < nums1.length; i++){
           for(int j = 0; j < nums2.length; j++){
               int curMax = maxLength(nums1, nums2, i, j);
               if(curMax > subSize){
                   subSize = curMax;
                   subIndex = i;
               }
           }
       }
       //[subIndex:subIndex+subSize]
       System.out.println(subIndex);
       return subSize;
   }
   
   private static int maxLength(int[] nums1, int[] nums2, int i, int j){
       int maxLength = 0;
       while(i < nums1.length && j < nums2.length){
           if(nums1[i] == nums2[j]){
               maxLength++;
               i++;
               j++;
           }else{
               return maxLength;
           }
       }
       return maxLength;
   }
}

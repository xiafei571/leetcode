package algo.expert;

import java.util.Arrays;

public class TandemBicycle {
	 public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
		    // Write your code here.
				//2 3 5 5 9
				//7 6 3 2 1
				//1 2 3 6 7
				Arrays.sort(redShirtSpeeds);
				Arrays.sort(blueShirtSpeeds);
				int sum = 0;
				
				for(int i = 0; i < redShirtSpeeds.length; i++){
					if(fastest){
						sum+=Math.max(redShirtSpeeds[i], blueShirtSpeeds[redShirtSpeeds.length-i-1]);
					}else{
						sum+=Math.max(redShirtSpeeds[i], blueShirtSpeeds[i]);
					}
					
				}
				
		    return sum;
		  }
}

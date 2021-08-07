package am;

import java.util.Arrays;

public class MaxAreaCake1465 {
	public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int mod = 1000000007;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        long hor = 0l;
        long ver = 0l;
        
        for(int i = 1; i < horizontalCuts.length; i++) {
        	hor = Math.max(hor, horizontalCuts[i] - horizontalCuts[i-1]);
        }
        
        hor = Math.max(hor, horizontalCuts[0] - 0);
        hor = Math.max(hor, h - horizontalCuts[horizontalCuts.length - 1]);
        
        for(int i = 1; i < verticalCuts.length; i++) {
        	ver = Math.max(ver, verticalCuts[i] - verticalCuts[i-1]);
        }
        
        ver = Math.max(ver, verticalCuts[0] - 0);
        ver = Math.max(ver, w - verticalCuts[verticalCuts.length - 1]);
        
        return (int) ((hor * ver) % mod);
    }
}

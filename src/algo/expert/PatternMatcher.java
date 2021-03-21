package algo.expert;

public class PatternMatcher {

	public static void main(String[] args) {
//		String[] result = patternMatcher("xxyxxy", "gogopowerrangergogopowerranger");
		String[] result = patternMatcher("xxxx", "testtesttesttest");
		System.out.println(result[0] + " " + result[1]);
	}

	public static String[] patternMatcher(String pattern, String str) {
	    // Write your code here.
			String[] patterns = pattern.split("");
			
			String[] xy_order = {"x", "y"};
			
			if(pattern.substring(0, 1).equals("y")){
				xy_order[0] = "y";
				xy_order[1] = "x";
			}
			
			//1. getCountofXandY
			int cnt_x = 0;
			int cnt_y = 0;
			int first_y = 0;
			
			for(int i = 0; i < patterns.length; i++){
				String p = patterns[i];
				if(p.equals(xy_order[0])){
					cnt_x++;
				}else{
					cnt_y++;
					//2. find first diff
					if(first_y == 0){
						first_y = i;
					}
				}
			}
			
			//3. calcurate len x, len y
			int len_x = 0;
			int len_y = 0;
			for(int j = 1; j < str.length() / cnt_x + 1; j++){
				len_x = j;
				
				String x = str.substring(0, len_x);
				String y = "";
				
				if(cnt_y == 0){

				}else if((str.length() - (len_x * cnt_x)) % cnt_y == 0){
					len_y = (str.length() - (len_x * cnt_x)) / cnt_y;
					y = str.substring(first_y * len_x, first_y * len_x + len_y);
				}else{
					continue;
				}
					
				if(xy_order[0].equals("y")){
					String temp = x;
					x = y;
					y = temp;
				}

				if(match(x, y, pattern, str)){
					return new String[] {x, y};
				}
			}
			//4. assumate x, y
			
	    return new String[] {};
	  }
		
		private static boolean match(String x, String y, String pattern, String str){
			String[] patterns = pattern.split("");
			int strIdx = 0;
			for(int i = 0; i < patterns.length; i++){
				if(patterns[i].equals("x")){
					
					if(strIdx + x.length() > str.length()){
						return false;
					}
					
					String subStr = str.substring(strIdx, strIdx + x.length());
					
					if(!subStr.equals(x)){
						return false;
					}else{
						strIdx += x.length();
					}
					
				}else{
					
					if(strIdx + y.length() > str.length()){
						return false;
					}
					
					String subStr = str.substring(strIdx, strIdx + y.length());
					if(!subStr.equals(y)){
						return false;
					}else{
						strIdx += y.length();
					}
				}
			}
			
			return true;
		}
}

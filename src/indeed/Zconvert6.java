package indeed;

public class Zconvert6 {

	public static String convert(String s, int numRows) {
		if(numRows == 1){
            return s;
        }
		
		String result = "";
		
		for (int i = 0; i < numRows; i++) {
			int idx = i;
			int step = 2 * (numRows - 1);//4
			
			while (idx < s.length()) {
				int append_idx = idx + step - (2 * i);
				result += s.charAt(idx);
				if(i != 0 && i != numRows - 1 &&  append_idx < s.length()) {
					result += s.charAt(append_idx);
				}
				idx += step;
				
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println("PAHNAPLSIIGYIR".equals(convert("PAYPALISHIRING", 3)));
		System.out.println("PINALSIGYAHRPI".equals(convert("PAYPALISHIRING", 4)));
	}
}

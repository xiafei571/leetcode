package am;

public class IntToRoman12 {

	final static int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
	final static String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

	public String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < symbols.length; i++) {
			int value = values[i];
			while (num >= value) {
				num = num - value;
				sb.append(symbols[i]);
			}
		}

		return sb.toString();
	}
}

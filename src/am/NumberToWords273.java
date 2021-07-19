package am;

import org.apache.commons.lang3.StringUtils;

public class NumberToWords273 {

	// One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand
	// Eight Hundred Ninety One
	final static String[] special = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
			"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
	final static String[] tens = { "", "Ten ", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ",
			"Eighty ", "Ninety " };
	final static String[] throusands = { " Thousand ", " Million ", " Billion " };

	public static void main(String[] args) {
		// "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven
		// Thousand Eight Hundred Ninety One"
		System.out.println(numberToWords(1000010));
		System.out.println(numberToWords(101));
		System.out.println(numberToWords(1000000));
		System.out.println(numberToWords(2000));
		System.out.println(numberToWords(100000));
	}

	public static String numberToWords(int num) {
		if (num == 0) {
			return "Zero";
		}
		int billion = num / 1000000000;
		int million = (num - billion * 1000000000) / 1000000;
		int thousand = (num - billion * 1000000000 - million * 1000000) / 1000;
		int rest = num - billion * 1000000000 - million * 1000000 - thousand * 1000;

		StringBuilder sb = new StringBuilder();
		if (billion != 0)
			sb.append(covertToWord(billion)).append(" Billion");

		if (million != 0) {
			if (!StringUtils.isBlank(sb))
				sb.append(" ");
			sb.append(covertToWord(million)).append(" Million");
		}
		if (thousand != 0) {
			if (!StringUtils.isBlank(sb))
				sb.append(" ");
			sb.append(covertToWord(thousand)).append(" Thousand");
		}
		if (rest != 0) {
			if (!StringUtils.isBlank(sb))
				sb.append(" ");
			sb.append(covertToWord(rest));
		}

		return sb.toString().replaceAll("  ", " ");
	}

	private static String covertToWord(int num) {
		if (num < 20) {
			return special[num];
		} else if (num < 100) {
			return tens[num / 10] + special[num % 10];
		} else {
			if (num % 100 < 20) {
				return special[num / 100] + " Hundred " + special[num % 100];
			} else {
				return special[num / 100] + " Hundred " + tens[(num % 100) / 10] + special[num % 10];
			}

		}
	}
}

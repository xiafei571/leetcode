package bytedance;

public class GetMaxDrink {
	public static void main(String[] args) {
		System.out.println(55 == getMaxDrink(30));
		System.out.println(1 == getMaxDrink(2));
		System.out.println(0 == getMaxDrink(1));
	}
	
	private static int getMaxDrink(int n) {
		//2 empty bottles = 1 new
		//4 caps = 1 new
		int bott = n / 2;
		int empBott = bott;
		int caps = bott;
		
		while(empBott >=2 || caps >= 4) {
			int exchange = empBott / 2 + caps / 4;
			empBott = empBott % 2;
			caps = caps % 4;
			bott += exchange;
			empBott+= exchange;
			caps += exchange;
		}
		return bott;
	}
}

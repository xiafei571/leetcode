package algo.expert;

public class Random {
	public static void main(String[] args) {
		isPassOrFail(100);
		isPassOrFail(99);
		isPassOrFail(60);
		isPassOrFail(0);
		
		Janken(new String[] {"2"});
	}

	private static void isPassOrFail(int score) {
		if (score == 100) {
			System.out.println("合格");
		} else {
			System.out.println("不合格");
		}
	}

	private static void Janken(String[] args) {
		// 乱数の初期化処理です。以下の１行は編集しないでください。
		java.util.Random rand = new java.util.Random(Integer.valueOf(args[0]));
		// 以下に解答を入力してください。
		int com1 = rand.nextInt(3); //0-2: [0, 1, 2]
		if (com1 == 0) {
			System.out.println("コンピュータA：グー");
		} else if (com1 == 1) {
			System.out.println("コンピュータA：パー");
		} else{
			System.out.println("コンピュータA：チョキ");
		}

		int com2 = rand.nextInt(3);//[0,1,2]
		if (com2 == 0) {
			System.out.println("コンピュータB：グー");
		} else if (com2 == 1) {
			System.out.println("コンピュータB：パー");
		} else{
			System.out.println("コンピュータB：チョキ");
		}
		
		if (com1 == com2) {
			System.out.println("あいこ");
		} else {// 0石头 1布 2剪子
			if (com1 == com2 + 1 || (com1 == 0 && com2 == 2)) {
				System.out.println("コンピュータAの勝ち");
			} else {
				System.out.println("コンピュータAの負け");
			}
		}
	}
}

package g;

public class SelfEva {
	public static void main(String[] args) {
		Integer[][] aa = { 
				{ 4, 2, 4, 2 }, 
				{ 4, null, 4, 2 }, 
				{ 2, null, 8, 2 }, 
				{ 16, null, 4, null } };

		Integer[][] a = { 
				{ null, null, null, null }, 
				{ null, null, null, null }, 
				{ null, null, null, null }, 
				{ null, null, null, null } };
		
		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 3; x++) {
				if (a[x + 1][y] != null) {
					if (a[x + 1][y] == a[x][y]) {
						a[x][y] = a[x][y] * 2;
						a[x + 1][y] = null;
					}

					if (a[x][y] == null) {
						a[x][y] = a[x + 1][y];
						a[x + 1][y] = null;
					}
				}
			}
		}
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j]+"    ");
			}
			System.out.println();
		}
	}
	
	
}

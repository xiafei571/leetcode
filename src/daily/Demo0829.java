package daily;

import java.util.Random;
/**
 * 	生成指定要求数组
 * @author user
 *
 */
public class Demo0829 {
	
	/*
	 * n^3 -> n^2 -> nlogn ->n ->1
	 * 
	 * 1. 生成数组
	 * 【随机】生成NxM的二维数组，要求数字1在每一行数组中只能出现一次且至少出现一次，其他数组由0-M任意填充
	 * 例如：
	 * 0 0 0 0 1 2 2 0 3 0
	 * 1 2 2 3 3 4 4 5 5 6
	 * 3 2 1 2 3 4 5 6 7 8
	 */
	private static int[][] generated_2Dseq(int n, int m){
		Random random = new Random();
		int[][] result = new int[n][m];
		for(int i = 0; i < result.length; i++) {
			int index = random.nextInt(m);
			result[i][index] = 1;
			for(int j = 0; j < result[i].length; j++) {
				int random_num = random.nextInt(m);
				if(random_num == 1) {
					random_num = random_num + random.nextInt(m) + 1;
				}
				
				if(j != index) {
					result[i][j] = random_num;
				}
			}
			
		}
		return result;
	}
	
	/*
	 * 2. 生成数组
	 * 【随机】生成NxM的二维数组, 要求数字只能是0-M，且每行内的所有数字不能重复
	 * 例如：
	 * 1 3 2 4 5 0
	 * 2 1 3 4 5 0
	 * 0 2 1 3 4 5
	 */
	private static int[][] generated_2Dseq2(int n, int m) {
		Random random = new Random();
		
		int[][] result = new int[n][m];
		
		for(int i = 0; i < result.length; i++) {
			for(int j = 0; j < result[i].length; j++) {
				result[i][j] = j;
			}
			
			for(int j = 0; j < result[i].length; j++) {
				int i1 = random.nextInt(result[i].length);
				int i2 = random.nextInt(result[i].length);
				if(i1 != i2) {
					int temp = result[i][i1];
					result[i][i1] = result[i][i2];
					result[i][i2] = temp;
				}
			}
		}
		
		return result;
	}
	
	/*
	 * 打印数组
	 */
	private static void print2DArray(int[][] array) {
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		print2DArray(generated_2Dseq(3,10));
		System.out.println();
		print2DArray(generated_2Dseq2(3,10));
	}

}

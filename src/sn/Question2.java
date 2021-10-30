package sn;

public class Question2 {
	
	public static void main(String[] args) {
		System.out.println(solution(new int[] {3,2,3,2,3}));
	}
	public static int solution(int[] A) {
        // write your code in Java SE 8
        if(A.length == 0){
            return 0;
        }

        if(A.length == 1){
            return 1;
        }

        int max = 0;
        for(int i = 0; i < A.length - 1; i++){
            max = Math.max(longestArray(A, i), max);
            if(max == A.length) {
            	return max;
            }
        }

        return max;
    }

    private static int longestArray(int[] A, int start){
        int i = start;
        int j = start + 1;
        int end = start;

        int odd = A[i];
        int even = A[j];

        while(i < A.length){
        	
            if(i + 2 < A.length && A[i+2] == odd){
                i = i + 2;
            }else {
            	end = Math.max(i, j);
            	break;
            }

            if(j + 2 < A.length && A[j+2] == even){
                j = j + 2;
            }else {
            	end = Math.max(i, j);
            	break;
            }
        }
        return end - start + 1;
    }
}

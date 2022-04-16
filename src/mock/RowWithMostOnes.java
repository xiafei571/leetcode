package mock;

public class RowWithMostOnes {
/* 
 * 

Tips:

  1. Questions (Clarify the question)
  2. Designing your Algorithm (Pseudocode if interviewer wants (ask them first if you shuold write), or just explain your algorithm)
  3. Implementation of your algorithm (Coding)
  4. Testing (pretty important. run through the test cases with your code, with the interviewer) 

Feedback:
	Pretty good Communication -> Explain your algorithm and good job asking for help when you were stuck
  Coding syntax and ability --> Very pretty + nice
  





Code Reviews: 


	You are given a 2D array of 0s and 1s. Each row of this 2D array is sorted. Find the row with the greatest number of 1s. Optimize if we can

Sample input:

matrix = 
[[0,0,0,1,1],
 [0,0,1,1,1],
 [0,0,0,0,1],
 [0,1,1,1,1],
 [0,0,1,1,1]]

Output: 3 (the row, 0-indexed)

Leetcode Medium
*/

// 1. brute force Time O(N*M) 

// 2. O(N*logM) --> Better?

// 3. O(N + M) 

// 4. O(LogN + M)


public int rowWithMostOnes(int[][] matrix){
  if(matrix.length == 0){
    return -1;
  }

  int res = matrix[0].length;
  int curFirstIdx = matrix.length;
  for(int i = 0; i < matrix.length; i++){
    int firstIdxOfOne = binarySearch(matrix[i]);//LogM
    if(firstIdxOfOne < curFirstIdx){ // if ( 1 < 0)
      curFirstIdx = firstIdxOfOne;
      res = i; // res = 0
    }
  }
  
  return res;
}

// Finding index of first 1 in row
private int binarySearch(int[] row) {
  int left = 0;
  int right = row.length;
  int result = -1;
  
  while (left <= right) {
    int mid = left + (right - left) / 2;
    
    if (row[mid] == 1) {   // [0,1,1,1,1,1,1]
      result = mid;
      right = mid - 1;
    } else {
      left = mid + 1;
    }
  }
  
  return result;
}

// Binary Search
private int binarySearch1(int[] row, int target) { // return index of target if it exists
  int left = 0;
  int right = row.length;
  
  while (left <= right) {
    int mid = left + (right - left) / 2;
    if (row[mid] == target) return mid;
    else if (row[mid] < target) {
      left = mid + 1; //
    } else {
      right = mid - 1;
    }
  }
	return left;
}



// Iteratively, not recursively
private int binarySearch2(int[] row){
  int idx = row.length / 2; // (middle)
  int firstIdx = row.length; // what to return
  // [0,1,1,1,1],
  while(idx > 0 && idx < row.length){ // while index is within bounds
    if(row[idx] == 1){// in left
      if(idx < firstIdx){
        firstIdx = idx;
      }
      idx = idx / 2;
    }else{//in right
      idx = (idx + row.length) / 2;
    }
  }
  
  return firstIdx;
}


}

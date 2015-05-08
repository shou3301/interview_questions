/*
Description
Given a sorted array A of distinct integers,  find a magic index if it exists in array A.  

A magic index in an array A[0…n-l] is defined as an index so that A[i] = i. 

Input
The input should be a list of N integers, where N is less than or equal to 10,000. The absolute values of all intergers should be less than 1,000,000,000.

Output
The output should be the first magic index if it exists. Otherwise the output should be -1.

Sample Input
0 1 2
Sample Output
O
*/

class Solution {
    int res = -1;
    
	public int getMagicIndex(int [] A) {
        bs(A, 0, A.length - 1);
        return res;
    }
    
    public void bs(int[] A, int s, int e) {
        if (s > e) return;
        
        int m = (s + e) / 2;
        
        if (A[m] - m == 0) res = m;
        
        if (A[m] - m >= 0)
            bs(A, s, m - 1);
        else
            bs(A, m + 1, e);
    }
}
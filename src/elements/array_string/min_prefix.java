/*
Description
You are given a non-empty zero-based indexing array A that consists of N integers, find the smallest integer P so that all the integers in array A are also in the subarray A[0......P]. 

Input
The input should be a list of N non-negative integers less than 1,000,000, where N should be less than or equal to 1,000,000.

Output
The output should be the smallest integer P.

Sample Input
2 2 1 0 1
Sample Output
3
*/

class Solution {
	public int leastPrefix(int [] A) {
        Set<Integer> set = new HashSet<>();
        int hold = 0;
        set.add(A[0]);
        
        for (int i = 1; i < A.length; i++) {
            if (!set.contains(A[i])) {
                hold = i;
                set.add(A[i]);
            }
        }
        
        return hold;
	}
}
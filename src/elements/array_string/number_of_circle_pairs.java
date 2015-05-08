/*
Description
You are given n circles centered on Y-aixs. The ith circle’s center is at point (i, 0) and its radius is A[i]. Count the number of pairs of circles that have at least one common point?

Input
The input should be a list of n positive integers A, each of them should be less than or equal to 1,000,000,000 and n should be less than or equal to 100,000.

Output
The output should be the number of pairs of circles that have at least one common point in the format of Integer.

Sample Input
1 2 3
Sample Output
3
*/

class Solution {
 	long countPairs(int [] A) {
        long res = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) continue;
            int j = i + 1;
            while (j < A.length) {
                if (A[j] == 0) j++;
                if (j - A[j] >= i - A[i] && j + A[j] >= i + A[i] && j - A[j] <= i + A[i]) res++;
                j++;
            }
        }
        
        return res;
    }
}
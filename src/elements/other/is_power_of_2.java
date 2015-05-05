/*
Description
You are given an integer, how would you check if it is a power of 2 efficiently? In mathematics, a power of two means a number of the form 2n where n is an integer.

Input
The input should be a non negative integer less than 109. 

Output
The output should be in the format of "true" or "false". 

Sample Output
No
*/
class Solution {
	public boolean isPowerOf2(int n) {
        int c = 0;
        while (n != 0) {
            c += n & 1;
            n = n >> 1;
        }
        
        return c == 1;
    }	
}
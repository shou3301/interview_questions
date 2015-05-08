/*
Description
 Write a function to multiply two integers without using any of the arithmetic operator, like *.

Input
The input should be two non-negative integers less than 1,000,000,000.

Output
The result should be in the format of Integer.

Sample Input
2 3
Sample Output
6
*/

class Solution {
	public long aMultiplyb(int a,int b) {
        if (a == 0 || b == 0) return 0;
        if (a == 1) return b;
        if (b == 1) return a;
        
        long res = 0;
        while (b > 0) {
            int count = 0;
            while ((1 << count) <= b) {
                count++;
            }
            
            res += (a << (count - 1));
            b -= (1 << (count - 1));
        }
        
        return res;
	}
}
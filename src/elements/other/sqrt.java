/*
Implement int sqrt(int x).

Compute and return the square root of x.
*/
public class Solution {
    public int mySqrt(int x) {
        if (x == 1 || x == 0) return x;
        
        long l = 1, r = x / 2;
        while (l <= r) {
            long m = (l + r) / 2;
            if (m * m == x) return new Long(m).intValue();
            if (m * m < x) l = m + 1;
            else r = m - 1;
        }
        
        return new Long(r).intValue();
    }
}
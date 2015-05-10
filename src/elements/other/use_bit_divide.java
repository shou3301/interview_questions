public class Solution {
    public int divide(int dividend, int divisor) {
        boolean neg = dividend > 0 &&  divisor < 0 || dividend < 0 &&  divisor > 0;
        
        long d1 = Math.abs((long) dividend);
        long d2 = Math.abs((long) divisor);
        
        if (d1 < d2) return 0;
        
        long res = 0;
        while (d1 >= d2) {
            int count = 0;
            while ((d2 << count) <= d1) {
                count++;
            }
            
            res += (1L << (count - 1));  // Important! Use 1L as long.
            d1 -= (d2 << (count - 1));
        }
        
        if (!neg)
            if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            else return new Long(res).intValue();
        else
            if (-res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            else return new Long(-res).intValue();
    }
}
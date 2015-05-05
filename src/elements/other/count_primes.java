/*
Count the number of prime numbers less than a non-negative number, n
*/

public class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        
        boolean[] record = new boolean[n];
        Arrays.fill(record, true);
        
        for (int i = 2; i < n; i++) {
            if (record[i]) {
                for (int j = 2; j * i < n; j++) {
                    record[j * i] = false;
                }
            }
        }
        
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (record[i]) count++;
        }
        
        return count;
    }
}
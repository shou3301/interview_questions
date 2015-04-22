public class Solution {
    public boolean isHappy(int n) {
        if (n == 1) return true;
        Set<Integer> seen = new HashSet<>();
        int k = n;
        while (k != 1 && !seen.contains(k)) {
            seen.add(k);
            int next = 0;
            while (k != 0) {
                next += (k % 10) * (k % 10);
                k /= 10;
            }
            k = next;
        }
        
        return k == 1;
    }
}
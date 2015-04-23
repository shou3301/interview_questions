public class Solution {
    public int candy(int[] ratings) {
        if (ratings.length == 0) return 0;
        
        int[] count = new int[ratings.length];
        Arrays.fill(count, 1);
        
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                count[i] = count[i-1] + 1;
            }
        }
        
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                count[i] = Math.max(count[i], count[i+1] + 1);
            }
        }
        
        int res = 0;
        for (int i = 0; i < ratings.length; i++) res += count[i];
        
        return res;
    }
}
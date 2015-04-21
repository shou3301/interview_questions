public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length <= 1 || k == 0) return 0;
        
        if (k >= prices.length) return all(prices);
        
        int[][] local = new int[prices.length][k+1];
        int[][] global = new int[prices.length][k+1];
        
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i-1];
            for (int j = 1; j <= k; j++) {
                local[i][j] = Math.max(global[i-1][j-1] + Math.max(0, diff), local[i-1][j] + diff);
                global[i][j] = Math.max(local[i][j], global[i-1][j]);
            }
        }
        
        return global[prices.length - 1][k];
    }
    
    private int all (int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) res += prices[i] - prices[i-1];
        }
        return res;
    }
}
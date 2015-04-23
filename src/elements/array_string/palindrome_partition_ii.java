public class Solution {
    public int minCut(String s) {
        if (s == null || s.length() <= 1) return 0;
        
        int[] cut = new int[s.length()];
        boolean[][] isPan = new boolean[s.length()][s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            cut[i] = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || isPan[j+1][i-1])) {
                    isPan[j][i] = true;
                    if (j == 0) {
                        cut[i] = 0;
                    } else {
                        cut[i] = Math.min(cut[i], cut[j-1] + 1);
                    }
                }
            }
        }
        
        return cut[s.length() - 1];
    }
}
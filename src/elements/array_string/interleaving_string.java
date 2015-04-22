public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        
        boolean[][] memo = new boolean[s1.length() + 1][s2.length() + 1];
        memo[0][0] = true;
        
        for (int i = 1; i <= s1.length(); i++) {
            if (s1.charAt(i-1)== s3.charAt(i-1)) {
                memo[i][0] = true && memo[i-1][0];
            } else {
                memo[i][0] = false;
            }
        }
        
        for (int i = 1; i <= s2.length(); i++) {
            if (s2.charAt(i-1)== s3.charAt(i-1)) {
                memo[0][i] = true && memo[0][i-1];
            } else {
                memo[0][i] = false;
            }
        }
        
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i-1) == s3.charAt(i+j-1)) {
                    memo[i][j] |= memo[i-1][j];
                }
                if (s2.charAt(j-1) == s3.charAt(i+j-1)) {
                    memo[i][j] |= memo[i][j-1];
                }
            }
        }
        
        return memo[s1.length()][s2.length()];
    }
}
/*
Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
*/

public class Solution {
    public int numDistinct(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return 0;
        
        int[][] seq = new int[s.length() + 1][t.length() + 1];
        
        for (int i = 0; i <= t.length(); i++) {
            seq[0][i] = 0;
        }
        for (int i = 0; i <= s.length(); i++) {
            seq[i][0] = 1;
        }
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                seq[i][j] = seq[i-1][j];
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    seq[i][j] += seq[i-1][j-1];
                }
            }
        }
        
        return seq[s.length()][t.length()];
    }
}
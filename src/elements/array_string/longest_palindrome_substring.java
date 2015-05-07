/*
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, 
and there exists one unique longest palindromic substring.
*/

public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // center i
            int j = i - 1, k = i + 1;
            while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
                j--;
                k++;
            }
            if (k - j - 1 > res.length()) res = s.substring(j + 1, k);
            
            // center i and i + 1
            j = i; 
            k = i + 1;
            while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
                j--;
                k++;
            }
            if (k - j - 1 > res.length()) res = s.substring(j + 1, k);
        }
        
        return res;
    }
}
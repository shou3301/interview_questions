/*
Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. 
Find and return the shortest palindrome you can find by performing this transformation.

For example:

Given "aacecaaa", return "aaacecaaa".

Given "abcd", return "dcbabcd".
*/

public class Solution {
    public String shortestPalindrome(String s) {
        int numOfMatch = maxPrefixSuffix(s + "#" + new StringBuilder(s).reverse().toString());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length() - numOfMatch; i++) {
            sb.append(s.charAt(s.length() - 1 - i));
        }
        sb.append(s);
        
        return sb.toString();
    }
    
    private int maxPrefixSuffix(String s) {
        int k = -1, j = 0;
        int[] next = new int[s.length() + 1];
        next[j] = k;
        
        while (j < s.length()) {
            while (k >= 0 && s.charAt(k) != s.charAt(j)) {
                k = next[k];
            }
            k++;
            j++;
            next[j] = k;
        }
        
        return next[s.length()];
    }
}
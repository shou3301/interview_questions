/*
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
*/

// DP solution
public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
        match[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i - 1) != '*') {
                match[0][i] = false;
            } else {
                match[0][i] = match[0][i-2];
            }
        }
        for (int i = 1; i <= s.length(); i++) {
            match[i][0] = false;
        }
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') {
                    match[i][j] = match[i-1][j-1];
                } else if (p.charAt(j-1) != '*') {
                    match[i][j] = false;
                } else {
                    match[i][j] = match[i][j-2];
                    if (p.charAt(j - 2) == '.' || s.charAt(i-1) == p.charAt(j-2)) {
                        match[i][j] |= match[i-1][j];
                    }
                }
            }
        }
        
        return match[s.length()][p.length()];
    }
}
// Wildcard mathcing
public class Solution {
    public boolean isMatch(String s, String p) {
        int si = 0, pi = 0, ss = -1, ps = -1;
        boolean metStar = false;
        
        while (si < s.length()) {
            if (pi < p.length() && (p.charAt(pi) == s.charAt(si) || p.charAt(pi) == '?')) {
                si++;
                pi++;
            } else if (pi < p.length() && p.charAt(pi) == '*') {
                int j = pi;
                while (j < p.length() && p.charAt(j) == '*') j++;
                if (j == p.length()) return true;
                
                metStar = true;
                ss = si;
                ps = j;
                pi = j;
            } else {
                if (!metStar) return false;
                ss++;
                si = ss;
                pi = ps;
            }
        }
        
        while (pi < p.length() && p.charAt(pi) == '*') pi++;
        
        return pi == p.length();
    }
}
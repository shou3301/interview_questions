/**
 * One edit distance.
 */
 
public class Solution {
    
    public boolean isOneEditDistance(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        
        if (l1 > l2) return isOneEditDistance(s2, s1);
        
        if (l2 - l1 > 1) return false;
        
        if (l1 != l2) {
            for (int i = 0; i < l1; i++) {
                if (s1.charAt(i) != s2.charAt(i))
                    return false;
            }
        } else {
            boolean diff = false;
            for (int i = 0, j = 0; j < l2; ) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    i++;
                    j++;
                } else {
                    if (diff) return false;
                    diff = true;
                    j++;
                }
            }
        }
        
        return true;
    }
    
}

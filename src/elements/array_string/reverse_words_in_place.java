/**
 * Reverse words in a sentence in place.
 */
public class Solution {
    public String reverseWords(String s) {
        char[] chs = s.toCharArray();
        
        reverse(chs, 0, chs.length - 1);
        
        for (int i = 0, j = 0; i < chs.length; i++) {
            if (chs[i] == ' ') {
                reverse(chs, j, i - 1);
                j = i + 1;
            } else if (i == chs.length - 1) {
                reverse(chs, j, i);
            }
        }
        
        return new String(chs);
    }
    
    private void reverse(char[] chs, int s, int e) {
        if (s >= e) return;
        
        for (int i = s; i <= (s + e) / 2; i++) {
            char tmp = chs[i];
            chs[i] = chs[e - (i - s)];
            chs[e - (i - s)] = tmp;
        }
    }
}
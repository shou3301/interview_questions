/*
KMP
*/

public class KMP {
    public void printMatch(String s, String p) {
        int i = 0, j = 0;
        int[] next = prepare(p);
        
        while (i < s.length()) {
            while (j >= 0 && s.charAt(i) != p.charAt(j)) {
                j = next[j];
            }
            i++;
            j++;
            if (j == p.length()) {
                System.out.println("Find match starting index: " + (i - p.length()));
                j = next[j];
            }
        }
    }
    
    /**
     * Find the longest prefix that is also a suffix.
     */
    private int[] prepare(String p) {
        int k = -1, j = 0;
        int[] next = new int[p.length() + 1];
        next[j] = k;
        
        while (j < p.length()) {
            while (k >= 0 && p.charAt(k) != p.charAt(j)) {
                k = next[k];
            }
            j++;
            k++;
            next[j] = k;
        }
        
        return next;
    }
}
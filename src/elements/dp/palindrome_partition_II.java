public class Solution {
    public int minCut(String s) {
        if (s.length() <= 1) return 0;
        int res = s.length();

        boolean[][] isPan = new boolean[s.length()][s.length()];
        int[] cuts = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
        	cuts[i] = i;
        	for (int j = 0; j <= i; j++) {
        		if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || isPan[j+1][i-1])) {
        			isPan[j][i] = true;
        			if (j == 0) {
        				cuts[i] = 0;
        			} else {
        				cuts[i] = Math.min(cuts[i], cuts[j-1] + 1);
        			}
        		}
        	}
        }

        return cuts[s.length() - 1];
    }
}
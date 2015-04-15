/**
 * Minimum insertion needed to form a palindrome
 */
 
public int minInsertionToPalindrome(String str) {
    if (str.length() < 2) return 0;
    
    char[] chs = str.toCharArray();
    int[][] helper = new int[chs.length][chs.length];
    
    for (int gap = 1; gap < chs.length; gap++) {
        for (int i = 0; i < chs.length - gap; i++) {
            if (gap == 1) {
                if (chs[i] == chs[i+gap]) {
                    helper[i][i+gap] = 0;
                } else {
                    helper[i][i+gap] = 1;
                }
            } else {
                if (chs[i] == chs[i+gap]) helper[i][i+gap] = helper[i+1][i+gap-1];
                else helper[i][i+gap] = Math.min(helper[i+1][i+gap], helper[i][i+gap-1]) + 1;
            }
        }
    }
    
    return helper[0][chs.length - 1];
}
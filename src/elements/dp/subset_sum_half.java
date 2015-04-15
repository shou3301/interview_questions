/**
 * Subset of the array (all positives) sums up to half.
 */
 
class Solution {
    
    public boolean exists(int[] A) {
        if (A.length < 2) return false;
        
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        sum /= 2;
        
        boolean[][] helper = new boolean[A.length + 1][sum + 1];
        for (int i = 1; i <= sum; i++) {
            helper[0][i] = false;
        }
        for (int i = 0; i <= A.length; i++) {
            helper[i][0] = true;
        }
        
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= sum; j++) {
                helper[i][j] |= helper[i-1][j];
                if (j >= A[i-1]) {
                    helper[i][j] |= helper[i-1][j-A[i-1]];
                }
            }
        }
        
        return helper[A.length][sum];
    }
    
}
/**
 * Longest subarray whose sum <= K
 */
 
class Solution {
    
    public int longestSubarray(int[] A, int K) {
        if (A == null || A.length == 0) return 0;
        
        int[] sums = new int[A.length];
        sums[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            sums[i] = sums[i-1] + A[i];
        }
        
        int[] minSums = new int[A.length];
        minSums[A.length - 1] = sums[A.length - 1];
        for (int i = A.length - 2; i >= 0; i--) {
            minSums[i] = Math.min(sums[i], minSums[i+1]);
        }
        
        int res = 1;
        for (int i = 0; i < A.length; i++) {
            int idx = searchRightBond(minSums, i, A.length - 1, k + sums[i]);
            res = Math.max(res, idx - i + 1);
        }
        
        return res;
    }
    
    // The array is sorted. Why?
    // Find the last index that A[index] <= target
    private int searchRightBond(int[] A, int s, int e, int target) {
        if (s > e) return -1;
        
        int m = (s + e) / 2;
        
        if (A[m] > target) {
            return searchRightBond(A, s, m - 1, target);
        } else {
            if (m + 1 > e || A[m+1] > target) {
                return m;
            } else {
                return searchRightBond(A, m + 1, e, target);
            }
        }
    }
}
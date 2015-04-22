public class Solution {
    public int findMin(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    
    private int helper(int[] A, int s, int e) {
        if (s == e) return A[s];
        if (s + 1 == e) return Math.min(A[s], A[e]);
        
        int m = (s + e) / 2;
        
        if (A[s] < A[m]) {
            if (A[s] < A[e]) {
                return A[s];
            } else {
                return helper(A, m + 1, e);
            }
        } else if (A[s] > A[m]) {
            return helper(A, s, m);
        } else {
            return helper(A, s + 1, e);
        }
    }
}
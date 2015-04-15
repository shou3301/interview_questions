/**
 * Longest even length substring such that sum of first and second half is same
 */
 
public int longestSubarray(int[] A) {
    int[] sums = new int[A.length];
    sums[0] = A[0];
    for (int i = 1; i < A.length; i++) {
        sums[i] = sums[i-1] + A[i];
    }
    
    int maxLen = 0;
    for (int gap = 1; gap < A.length; gap += 2) {
        for (int i = 0; i < A.length - gap; i++) {
            int left = i == 0 ? sums[gap/2] : sums[gap/2] - sums[i-1];
            int right = sums[i+gap] - sums[gap/2];
            
            if (left == right) {
                maxLen = Math.max(maxLen, gap + 1);
            }
        }
    }
    
    return helper[0][A.length-1];
}
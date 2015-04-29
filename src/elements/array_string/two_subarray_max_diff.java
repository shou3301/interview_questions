/*
Given an array of integers. Find two disjoint contiguous subarrays such that the absolute difference between the sum of two subarray is maximum.
Note: The subarrays should not overlap.

For example:
Array: { 2, -1, -2, 1, -4, 2, 8 }
Result subarrays: {-1, -2, 1, -4 }, { 2, 8 }
Maximum difference = 16
*/

// Make use of max subarray

public int maxDiffOfTwoSubarray(int[] A) {
    if (A == null || A.length <= 1) return 0;
    
    int[] leftMax = new int[A.length];
    int[] leftMin = new int[A.length];
    int[] rightMax = new int[A.length];
    int[] rightMin = new int[A.length];
    
    leftMax[0] = A[0];
    leftMin[0] = A[0];
    int leftLocalMax = A[0];
    int leftLocalMin = A[0];
    for (int i = 1; i < A.length; i++) {
        leftLocalMax = Math.max(A[i], A[i] + leftLocalMax);
        leftLocalMin = Math.min(A[i], A[i] + leftLocalMin);
        leftMax[i] = Math.max(leftMax[i-1], leftLocalMax);
        leftMin[i] = Math.min(leftMin[i-1], leftLocalMin);
    }
    
    rightMax[A.length - 1] = A[A.length - 1];
    rightMin[A.length - 1] = A[A.length - 1];
    int rightLocalMax = A[A.length - 1];
    int rightLocalMin = A[A.length - 1];
    for (int i = A.length - 1; i >= 0; i--) {
        rightLocalMax = Math.max(A[i], rightLocalMax + A[i]);
        rightLocalMin = Math.min(A[i], rightLocalMin + A[i]);
        rightMax[i] = Math.max(rightMax[i+1], rightLocalMax);
        rightMin[i] = Math.min(rightMin[i+1], rightLocalMin);
    }
    
    int res = 0;
    for (int i = 0; i < A.length - 1; i++) {
        res = Math.max(res, Math.max(Math.abs(leftMax[i] - rightMin[i+1]), Math.abs(leftMin[i] - rightMax[i+1])));
    }
    
    return res;
}
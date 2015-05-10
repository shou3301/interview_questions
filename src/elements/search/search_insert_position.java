/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/
public class Solution {
    public int searchInsert(int[] nums, int target) {
        return bs(nums, 0, nums.length - 1, target);
    }
    
    public int bs(int[] A, int s, int e, int target) {
        if (s > e) return s;
        
        int m = (s + e) / 2;
        if (A[m] == target) return m;
        
        if (A[m] > target) return bs(A, s, m - 1, target);
        else return bs(A, m + 1, e, target);
    }
}
/*

*/

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return helper(nums, k, 0, nums.length - 1);
    }
    
    private int helper(int[] nums, int k, int s, int e) {
        int m = partition(nums, s, e);
        if (m - s == k - 1) return nums[m];
        if (m - s < k - 1) return helper(nums, k - (m - s + 1), m + 1, e);
        else return helper(nums, k, s, m - 1);
    }
    
    private int partition(int[] nums, int s, int e) {
        int p = nums[e];
        int j = s;
        for (int i = s; i < e; i++) {
            if (nums[i] >= p) {
                swap(nums, i, j++);
            }
        }
        
        swap(nums, j, e);
        
        return j;
    }
    
    private void swap(int[] nums, int i, int j) {
        if (i == j) return;
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
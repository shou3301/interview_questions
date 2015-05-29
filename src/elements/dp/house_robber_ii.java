/*
After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. 
This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. 
Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
*/

public class Solution {
    public int rob(int[] nums) {
        int res = 0;
        if (nums.length == 0) return res;
        else if (nums.length == 1) return nums[0];
        
        int[] max1 = new int[nums.length];
        int[] max2 = new int[nums.length];
        
        // rob 1st
        max1[0] = nums[0];
        max1[1] = max1[0];
        max2[0] = 0;
        max2[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            max1[i] = Math.max(max1[i-2] + nums[i], max1[i-1]);
            max2[i] = Math.max(max2[i-2] + nums[i], max2[i-1]);
        }
        
        return Math.max(max1[nums.length - 2], max2[nums.length - 1]);
    }
}
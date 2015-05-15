/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
*/

public class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) return true;
        
        int currBoard = 0, nextBoard = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > currBoard) {
                if (currBoard >= nextBoard) return false;
                currBoard = nextBoard;
            }
            nextBoard = Math.max(nextBoard, i + nums[i]);
        }
        
        return true;
    }
}
/*
Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
*/

// O(nlogn) solution
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        
        int[] sum = new int[len];
        sum[0] = nums[0];
        for (int i = 1; i < len; i++) {
            sum[i] = sum[i-1] + nums[i];
        }
        
        int[] rightMin = new int[len];
        rightMin[len - 1] = sum[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rightMin[i] = Math.min(sum[i], rightMin[i + 1]);
        }
        
        int init = bs(rightMin, 0, len - 1, s);
        int res = Integer.MAX_VALUE;
        if (init != -1) res = init + 1;
        
        for (int i = 0; i < len - 1; i++) {
            int j = bs(rightMin, i + 1, len - 1, s + sum[i]);
            if (j != -1) {
                res = Math.min(res, j - i);
            }
        }
        
        if (res == Integer.MAX_VALUE) return 0;
        return res;
    }
    
    public int bs(int[] A, int s, int e, int target) {
        if (s > e) return -1;
        if (s == e && A[s] >= target) return s;
        
        int m = (s + e) / 2;
        if (A[m] < target)
            return bs(A, m + 1, e, target);
        else
            return bs(A, s, m, target);
    }
}

// O(n) solution
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0, j = 0, sum = nums[0];
        int res = Integer.MAX_VALUE;
        
        while (j < nums.length) {
            if (sum < s) {
                if (j + 1 < nums.length) {
                    sum += nums[++j];
                } else
                    break;
            } else if (sum >= s) {
                res = Math.min(res, j - i + 1);
                sum -= nums[i++];
                if (i > j) j = i;
            }
        }
        
        if (res == Integer.MAX_VALUE) return 0;
        return res;
    }
}
/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/
public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) set.add(nums[i]);
        
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (set.contains(curr)) {
                int count = 1;
                int j = curr - 1;
                while (set.contains(j)) {
                    count++;
                    set.remove(j--);
                }
                j = curr + 1;
                while (set.contains(j)) {
                    count++;
                    set.remove(j++);
                }
                
                res = Math.max(res, count);
            }
        }
        
        return res;
    }
}
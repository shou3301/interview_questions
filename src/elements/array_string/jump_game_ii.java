public class Solution {
    public int jump(int[] nums) {
        int res = 0;
        if (nums == null || nums.length <= 1) return res;
        
        int currBorder = 0, nextBorder = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (i > currBorder) {
                currBorder = nextBorder;
                res++;
            }
            nextBorder = Math.max(nextBorder, i + nums[i]);
        }
        
        return res;
    }
}
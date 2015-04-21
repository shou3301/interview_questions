public class Solution {
    public int trap(int[] height) {
        int res = 0;
        
        if (height == null || height.length == 0) return res;
        
        int[] leftMax = new int[height.length];
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }
        
        int rightMax = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax = Math.max(rightMax, height[i]);
            res += Math.max(0, Math.min(rightMax, leftMax[i]) - height[i]);
        }
        
        return res;
    }
}
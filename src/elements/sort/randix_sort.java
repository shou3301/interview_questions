public class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length == 0) return 0;
        radixSort(nums);
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res, nums[i] - nums[i-1]);
        }
        
        return res;
    }
    
    private void radixSort(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        
        int exp = 1;
        while (max / exp > 0) {
            ArrayList<Integer>[] bucket = new ArrayList[10];
            for (int i = 0; i < 10; i++) {
                bucket[i] = new ArrayList<>();
            }
            
            for (int i = 0; i < nums.length; i++) {
                bucket[nums[i] / exp % 10].add(nums[i]);
            }
            
            int k = 0;
            for (int i = 0; i < 10; i++) {
                for (Integer j : bucket[i]) {
                    nums[k++] = j;
                }
            }
            
            exp *= 10;
        }
    }
}
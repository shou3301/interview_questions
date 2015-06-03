/*
Given an array of integers and an integer k, 
find out whether there there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
*/

public class Solution {
    
    protected class Container {
        public int val;
        public int index;
        public Container(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
    
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        List<Container> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(new Container(nums[i], i));
        }
        
        Collections.sort(list, new Comparator<Container>() {
            @Override
            public int compare(Container c1, Container c2) {
                if (c1.val != c2.val) {
                    return c1.val - c2.val;
                } else {
                    return c1.index - c2.index;
                }
            }
        });
        
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).val == list.get(i-1).val && list.get(i).index - list.get(i-1).index <= k)
                return true;
        }
        
        return false;
    }
}
public class Solution {
    
    protected class Container {
        public int val;
        public int index;
        public Container(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
    
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        List<Container> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(new Container(nums[i], i));
        }
        
        Collections.sort(list, new Comparator<Container>(){
           public int compare(Container c1, Container c2) {
               if (c1.val != c2.val) return c1.val - c2.val;
               return c1.index - c2.index;
           } 
        });
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length && list.get(i).val + t >= list.get(j).val; j++) {
                if (Math.abs(list.get(i).index - list.get(j).index) <= k) return true;
            }
        }
        
        return false;
    }
}
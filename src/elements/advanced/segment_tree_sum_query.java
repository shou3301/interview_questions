public class SegmentTree {
    
    public int[] arr;
    
    public int[] sg;
    
    public SegmentTree(int[] arr) {
        this.arr = arr;
        int height = Math.ceil(Math.log(arr.length));
        int size = (int) 2 * Math.pow(2, height) - 1;
        this.sg = new int[size];
        build(0, arr.length - 1, 0);
    }
    
    private void build(int s, int e, int index) {
        if (s == e) {
            sg[index] = arr[s];
            return;
        }
        
        int m = (s + e) / 2;
        sg[index] = build(s, m, 2 * index + 1) + build(m + 1, e, 2 * index + 2);
    }
    
    public int getSum(int start, int end) {
        return getSumHelper(start, end, 0, arr.length - 1, 0);
    }
    
    private int getSumHelper(int start, int end, int s, int e, int index) {
        if (s <= start && e >= end) return sg[index];
        
        if (end < s || start > e) return 0;
        
        int m = (s + e) / 2;
        return getSumHelper(start, end, s, m, 2 * index + 1) + getSumHelper(start, end, m + 1, e, 2 * index + 2);
    }
    
    public void update(int index, int newVal) {
        int diff = newVal - arr[index];
        updateHelper(0, arr.length - 1, index, 0, diff);
    }
    
    private void updateHelper(int s, int e, int i, int index, int diff) {
        if (i >= s && i <= e) {
            sg[index] += diff;
        }
        
        if (s == e || i < s || i > e) return;
        
        int m = (s + e) / 2;
        updateHelper(s, m, i, 2 * index + 1, diff);
        updateHelper(m + 1, e, 2 * index + 2, diff);
    }
    
}
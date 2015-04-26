public class SegmentTreeForRMQ {
    public int arr[];
    public int sg[];
    
    public SegmentTreeForRMQ(int[] arr) {
        this.arr = arr;
        int height = Math.ceil(Math.log(arr.length));
        int size = (int) 2 * Math.pow(2, height) - 1;
        sg = new int[size];
        build(0, arr.length - 1, 0);
    }
    
    private void build(int s, int e, int index) {
        if (s == e) {
            sg[index] = arr[s];
            return;
        }
        
        int m = (s + e) / 2;
        sg[index] = Math.min(build(s, m, 2 * index + 1), build(m + 1, e, 2 * index + 2));
    }
    
    public int rangeMin(int start, int end) {
        // omit validation
        return rangeMinHelper(0, arr.length - 1, start, end, 0);
    }
    
    private int rangeMinHelper(int s, int e, int start, int end, int index) {
        if (start <= s && end >= e) {
            return sg[index];
        }
        
        if (end < s || start > e) return Integer.MAX_VALUE;
        
        int m = (s + e) / 2;
        return Math.min(rangeMinHelper(s, m, start, end, 2 * index + 1), rangeMinHelper(m + 1, e, start, end, 2 * index + 2));
    }
    
    public void update(int index, int val) {
        
    }
    
    private void updateHelper(int s, int e, int i, int index, int val) {
        if (s <= i && i <= e) {
            sg[index] = Math.min(sg[index], val);
        }
        
        if (s == e) return;
        
        int m = (s + e) / 2;
        updateHelper(s, m, i, 2 * index + 1, val);
        updateHelper(m + 1, e, i, 2 * index + 2, val);
    }
}
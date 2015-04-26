/*
输入为一个Iterator数组，这些Iterator分别取出来的数都是已排序的，设计并实现一个MergeIterator类，merge这些sorted iterator。
你的MergeIterator类需要包含has_next和get_next方法。
注意，Iterator也只包含has_next和get_next方法。
*/

public class MergeIterator implements Iterator<Integer> {
    private List<Iterator> iters;
    private PriorityQueue<Wrapper> heap;
    
    public MergeIterator(List<Iterator> iters) {
        this.iters = iters;
        this.heap = new PriorityQueue<>(new Comparator<Wrapper>() {
            public int compare(Wrapper w1, Wrapper w2) {
                return w1.val - w2.val;
            }
        }); 
        for (Iterator iter : iters) {
            if (iter.hasNext()) {
                heap.offer(new Wrapper(iter.next(), iter));
            }
        }
    }
    
    public boolean hasNext() {
        return !heap.isEmpty();
    }
    
    public Integer next() {
        Wrapper w = heap.poll();
        if (w.iter.hasNext()) {
            heap.offer(new Wrapper(w.iter.next, w.iter));
        }
        return w.val;
    }
    
    protected Wrapper {
        public int val;
        public Iterator iter;
        public Wrapper(int val, Iterator iter) {
            this.val = val;
            this.iter = iter;
        }
    }
}
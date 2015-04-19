/**
 * Given K iterator, and we need to wrap them into one ZigZagIterator that will
 * output them one by one. For example, if you have two, then you should output
 * one from iter1 and then one from iter2. If one of them running out of elements,
 * then it should only return from the left one.
 */
 
public class ZigZagIterator implements Iterator<T> {
    
    private final List<Iterator<T>> iters;
    
    private int index;
    
    public ZigZagIterator(List<Iterator<T>> iters) {
        this.iters = iters;
        this.index = 0;
    }
    
    public T next() {
        T res = iters.get(index).next();
        // Find the next iterator that has next.
        // There is some minor optimization we can do here.
        int j = index;
        do {
            j = (j + 1) % iters.size();
        } while(!iters.get(index).hasNext() && j != index);
        index = j;
        
        return res;
    }
    
    public boolean hasNext() {
        iters.get(index).hasNext();
    }
}
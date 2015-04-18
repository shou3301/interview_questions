/**
 * PeekIterator - an iterator that provides a peek operation.
 */
 
public class PeekIterator {

    private Iterator<Integer> iter;
    
    private Integer buffer;
    
    public PeekIterator(Iterator<Integer> iter) {
        this.iter = iter;
    }
    
    public Integer next() {
        if (!hasNext()) return null;
        
        if (buffer != null) {
            Integer tmp = buffer;
            buffer = null;
            return tmp;
        }
        
        return iter.next();
    }
    
    public boolean hasNext() {
        return (buffer != null || iter.hasNext())
    }
    
    public Integer peek() {
        if (!hasNext()) return null;
        
        if (buffer != null) {
            return buffer;
        }
        
        buffer = iter.next();
        return buffer;
    }
}
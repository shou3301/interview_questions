/**
 * Find Kth largest elements in an array
 */
 
public int findKth(int[] A, int s, int e, int k) {
    // assume all input are valid
    if (s == e) return A[s];
    
    int r = random(s, e);
    swap(A, r, e);
    int idx = partition(A, s, e);
    
    if (idx == s + k - 1) return A[idx];
    
    if (idx < s + k - 1) {
        return findKth(A, idx + 1, e, k - (idx - s + 1));
    } else {
        return findKth(A, s, idx - 1, k);
    }
}

private int partition(int[] A, int s, int e) {
    int p = A[e];
    
    int hold = s;
    for (int i = s; i < e; i++) {
        if (A[i] <= p) {
            swap(A, hold++, i);
        }
    }
    
    swap(A, hold, e);
    
    return hold;
}
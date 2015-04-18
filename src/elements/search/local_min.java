/**
 * Find local min in an array - a local min is any A[i] that meets A[i-1] > A[i-1] && A[i+1] > A[i]
 * There is no duplicates in the array
 */
 
public int findLocalMin(int[] A, int s, int e) {
    if (s == e) return s;
    
    int m = (s + e) / 2;
    
    if ((m - 1 < s || A[m] < A[m-1]) && (m + 1 > e || A[m+1] > A[m]))
        return m;
    else if (m - 1 < s || (m + 1 <= e && A[m-1] >= A[m+1])) {
        return findLocalMin(A, m + 1, e);
    } else {
        return findLocalMin(A, s, m - 1);
    }
}
/*
一个array里面找最大的这样的h: 至少有h个数大于等于h。
比如{2,3,5}答案是2，{5,6,7,8}答案是4。
*/

// If the array is not sorted.
// Avg time O(n).
public int findMaxH(int[] A) {
    helper(A, 0, A.length - 1);
    return maxH;
}

int maxH = 0;

public void helper(int[] A, int s, int e) {
    if (s > e) return;
    
    int k = partition(A, s, e);
    
    if (A[k] <= A.length - k - 1) {
        maxH = Math.max(maxH, k);
        helper(A, m + 1, e);
    } else {
        helper(A, s, m - 1);
    }
}

public int partition(int[] A, int s, int e) {
    int pivot = A[e];
    
    int hold = s;
    for (int i = s; i < e; i++) {
        if (A[i] < pivot) {
            swap(A, hold++, i);
        }
    }
    
    swap(A, hold, e);
    
    return hold;
}
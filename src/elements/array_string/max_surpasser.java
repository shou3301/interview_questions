/*
Maximal Surpasser Count Problem

输入一个数组，返回数组元素的surpasser个数的最大值。
数组元素a[i] 的surpasser是指元素a[j], j > i， a[j] > a[i]。
比如[10, 3, 7, 1, 23, 14, 6, 9] 这个数组中10的surpasser是23,14，个数是2。而3的surpasser是7,23,14,6,9，个数为5，并且是最多的一个。所以返回5。
*/

// For simplicity, I assume there is no duplicates in the array
// Use divide and conquer

public int maxSurpasser(int[] A) {
    Map<Integer, Integer> record = new HashMap<>();
    surpasserHelper(A, 0, new int[A.length], 0, A.length - 1, record);
    
    int max = 0;
    for (Map.Entry<Integer, Integer> entry : record.entrySet()) {
        max = Math.max(entry.getValue(), max);
    }
    
    return max;
}

public void surpasserHelper(int[] A, int[] helper, int s, int e, Map<Integer, Integer> record) {
    if (s >= e) return;
    
    int m = (s + e) / 2;
    surpasserHelper(A, helper, s, m, record);
    surpasserHelper(A, helper, m + 1, e, record);
    
    int k = s, i = s, j = m + 1;
    while (i <= m && j <= e) {
        if (A[i] < A[j]) {
            if (record.containsKey(A[i])) {
                record.put(A[i], record.get(A[i]) + e - j + 1);
            } else {
                record.put(A[i], 1);
            }
            helper[k++] = A[i++];
        } else {
            helper[k++] = A[j++];
        }
    }
    
    while (i <= m) {
        helper[k++] = A[i++];
    }
    
    while (j <= e) {
        helper[j++] = A[j++];
    }
    
    for (int m = s; m <= e; m++) {
        A[m] = helper[m];
    }
}
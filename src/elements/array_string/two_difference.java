/*
Two difference.

有序数组中都是正数且为unique number，找出两个数A、B，so that A-B = 一个给定的数C。要求使用常数空间和O(N)时间。
*/

// the return array should have length = 2
// if there is no such two numbers return [-1, -1]
public int[] twoDiff(int[] A, int target) {
    int[] no = new int[] {-1, -1};
    if (A.length <= 1) return no;
    
    for (int p = 0, q = 1; q < A.length; ) {
        if (A[q] - A[p] == target) {
            return new int[] {p, q};
        } else if (A[q] - A[p] < target) q++;
        else p++;
        
        // This is important!
        if (p == q) q++;
    }
    
    return no;
}
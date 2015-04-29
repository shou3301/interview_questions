/*
Given a integer array, please determine if it is a postorder traversal result of an arbitrary Binary Search Tree.
For example:

{5,7,6,9,11,10,8} is valid
{7,4,6,5} is not valid
*/

public boolean validPostOrder(int[] A) {
    return helper(A, 0, A.length - 1);
}

public boolean helper(int[] A, int s, int e) {
    if (e - s <= 1) return true;
    
    int root = A[e];
    int m = s;
    while (A[m] < root) {
        m++;
    }
    
    // check right part
    for (int j = m; j < e; j++) {
        if (A[j] < root) return false;
    }
    
    return helper(A, s, m - 1) && helper(A, m, e - 1);
}
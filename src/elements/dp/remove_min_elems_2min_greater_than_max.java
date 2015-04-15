/**
 * Remove minimum elements from either side such that 2*min becomes more than max
 */
 
public int minRemove(int[] A) {
    if (A.length < 2) return 0;
    
    int[][] min = new int[A.length][A.length];
    int[][] max = new int[A.length][A.length];
    
    for (int i = 0; i < A.length; i++) {
        for (int j = i; j < A.length; j++) {
            if (i == j) {
                min[i][j] = A[i];
                max[i][j] = A[i];
            } else {
                min[i][j] = Math.min(min[i][j-1], A[j]);
                max[i][j] = Math.max(max[i][j-1], A[j]);
            }
        }
    }
    
    int[][] helper = new int[A.length][A.length];
    for (int gap = 1; gap < A.length; gap++) {
        for (int i = 0; i < A.length - gap; i++) {
            if (2 * min[i][i+gap] > max[i][j]) {
                helper[i][i+gap] = 0;
            } else {
                helper[i][i+gap] = Math.min(helper[i+1][i+gap], helper[i][i+gap-1]) + 1;
            }
        }
    }
    
    return helper[0][A.length - 1];
}
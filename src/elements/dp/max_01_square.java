public class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        if (n == 0) return 0;
        
        int[][] size = new int[m][n];
        int res = 0;
        
        for (int i = 0; i < m; i++) {
            size[i][0] = matrix[i][0] - '0';
            if (matrix[i][0] == '1') res = 1;
        }
        for (int i = 1; i < n; i++) {
            size[0][i] = matrix[0][i] - '0';
            if (matrix[0][i] == '1') res = 1;
        }
        
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    size[i][j] = Math.min(size[i-1][j], Math.min(size[i][j-1], size[i-1][j-1])) + 1;
                    res = Math.max(size[i][j], res);
                }
            }
        }
        
        return res * res;
    }
}
/*
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
*/

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        if (n == 0) return 0;
        
        int[][] helper = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    helper[i][j] = matrix[i][j] == '1' ? 1 : 0;
                } else {
                    helper[i][j] = matrix[i][j] == '1' ? helper[i-1][j] + 1 : 0;
                }
            }
        }
        
        int max = 0;
        for (int i = 0; i < m; i++) {
            max = Math.max(max, maxHis(helper[i]));
        }
        
        return max;
    }
    
    public int maxHis(int[] A) {
        if (A.length == 0) return 0;
        Stack<Integer> s = new Stack<>();
        
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            while (!s.empty() && A[s.peek()] >= A[i]) {
                int j = s.pop();
                int left = s.empty() ? -1 : s.peek();
                max = Math.max(max, (i - left - 1) * A[j]);
            }
            s.push(i);
        }
        
        while (!s.empty()) {
            int j = s.pop();
            int left = s.empty() ? -1 : s.peek();
            max = Math.max(max, (A.length - left - 1) * A[j]);
        }
        
        return max;
    }
}
/*
Longest Increasing Sequence in a Matrix.

Find the longest increasing(increasing means one step) sequence in an integer matrix in 4 directions (up down left right), return the sequence
*/

public class LongestIncreasing {
    List<Integer>[][] memo;
    
    public List<Integer> longestIncreasingSeq(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        List<Integer> res = new ArrayList<>();
        
        memo = new ArrayList[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                List<Integer> cand = bfs(matrix, i, j, m, n);
                if (cand.size() > res.size()) res = cand;
            }
        }
        
        return res;
    }
    
    public List<Integer> bfs(int[][] matrix, int x, int y, int m, int n) {
        if (x < 0 || y < 0 || x >= m || y >= n) {
            return new ArrayList<Integer>();
        }
        
        if (memo[x][y] != null) return memo[x][y];
        
        List<Integer> res = new ArrayList<Integer>();
        res.add(matrix[x][y]);
        
        List<Integer> next = new ArrayList<Integer>();
        
        if (y - 1 >= 0 && matrix[x][y-1] > matrix[x][y]) {
            List<Integer> l = bfs(matrix, x, y - 1, m , n);
            if (l.size() > next.size()) next = l;
        }
        
        if (y + 1 < n && matrix[x][y+1] > matrix[x][y]) {
            List<Integer> r = bfs(matrix, x, y + 1, m , n);
            if (r.size() > next.size()) next = r;
        }
        
        if (x - 1 >= 0 && matrix[x-1][y] > matrix[x][y]) {
            List<Integer> u = bfs(matrix, x - 1, y, m, n);
            if (u.size() > next.size()) next = u;
        }
        if (x + 1 < m && matrix[x+1][y] > matrix[x][y]) {
            List<Integer> d = bfs(matrix, x + 1, y, m , n);
            if (d.size() > next.size()) next = d;
        }
        
        res.addAll(next);
        memo[x][y] = res;
        
        return res;
    }
}

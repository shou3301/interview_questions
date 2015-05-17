/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3
*/

public class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        if (n == 0) return 0;
        
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    fill(grid, i, j, m, n);
                    res++;
                }
            }
        }
        
        return res;
    }
    
    private void fill(char[][] grid, int x, int y, int m, int n) {
        if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] != '1') return;
        
        grid[x][y] = 'x';
        
        fill(grid, x + 1, y, m, n);
        fill(grid, x - 1, y, m, n);
        fill(grid, x, y + 1, m, n);
        fill(grid, x, y - 1, m, n);
    }
}
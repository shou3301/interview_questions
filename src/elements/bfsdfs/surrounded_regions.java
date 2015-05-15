/*
Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
*/

public class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;
        if (n == 0) return;
        
        for (int i = 0; i < m; i++) {
            fill(board, i, 0, m, n);
            fill(board, i, n - 1, m, n);
        }
        
        for (int i = 0; i < n; i++) {
            fill(board, 0, i, m, n);
            fill(board, m - 1, i, m, n);
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '1') board[i][j] = 'O';
                else if (board[i][j] == 'o') board[i][j] = 'X';
            }
        }
    }
    
    public void fill(char[][] board, int x, int y, int m, int n) {
        Queue<Integer> xq = new LinkedList<>();
        Queue<Integer> yq = new LinkedList<>();
        xq.offer(x);
        yq.offer(y);
        
        while (!xq.isEmpty()) {
            int i = xq.poll();
            int j = yq.poll();
            
            if (board[i][j] == 'O') {
                board[i][j] = '1';
                if (i - 1 >= 0 && board[i-1][j] == 'O') {
                    xq.offer(i-1);
                    yq.offer(j);
                }
                if (i + 1 < m && board[i+1][j] == 'O') {
                    xq.offer(i+1);
                    yq.offer(j);
                }
                if (j - 1 >= 0 && board[i][j-1] == 'O') {
                    xq.offer(i);
                    yq.offer(j-1);
                }
                if (j + 1 < n && board[i][j+1] == 'O') {
                    xq.offer(i);
                    yq.offer(j+1);
                }
            }
        }
    }
}
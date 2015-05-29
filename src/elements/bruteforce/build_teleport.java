/*
Problem Statement
    
Note that this problem has a time limit of 5 seconds.  The city of Gridlock is a grid of cells with R rows and C columns. Each cell has up to four neighbours: the cells directly above, below, to the left, and to the right. A citizen of Gridlock can travel from a cell to any of its neighbours in one minute.  The citizens of Gridlock are upset that it takes too long to get around, so they have decided to build a teleporter. The teleporter will consist of two identical booths, each located in some cell. If a citizen enters either booth, he or she may choose to teleport to the other booth instantly. It is allowed to build both booths in the same cell.  We define the distance between two cells as the minimum number of minutes needed to get from one cell to another. Let D be the maximum distance between any two cells. Place the teleporter in such a way that D is minimized, and return this minimum value.
Definition
    
Examples
0)

    
4
1
Returns: 1
The optimal solution is to connect cell (1, 1) to cell (4, 1). (All cell coordinates are 1-based.)
1)

    
2
2
Returns: 1

2)

    
5
3
Returns: 4

3)

    
8
2
Returns: 4

*/

public class PublicTransit {
    
    public int minimumLongestDistance(int R, int C) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                for (int k = 0; k < R; k++) {
                    for (int l = 0; l < C; l++) {
                        // build teleport between [i, j] and [k, l]
                        int max = Integer.MIN_VALUE;
                        for (int si = 0; si < R; si++) {
                            for (int sj = 0; sj < C; sj++) {
                                for (int ei = 0; ei < R; ei++) {
                                    for (int ej = 0; ej < C; ej++) {
                                        int min = Math.abs(ei - si) + Math.abs(ej - sj);
                                        min = Math.min(min, Math.abs(si - i) + Math.abs(sj - j) + Math.abs(k - ei) + Math.abs(l - ej));
                                        min = Math.min(min, Math.abs(si - k) + Math.abs(sj - l) + Math.abs(ei - i) + Math.abs(ej - j));
                                        max = Math.max(max, min);
                                    }
                                }
                            }
                        }
                        res = Math.min(max, res);
                    }
                }
            }
        }
        return res;
    }
    
}
/*
Problem Statement
    
Devu has a garden in his back yard. The garden can be seen as a grid with 2 rows and N columns. You are given a description of the garden: a String[] garden with 2 elements, each containing N characters. The character '.' represents an empty grid cell, and the character '*' a cell that contains a tree.

Two cells are considered adjacent if they share a side or a corner. As you may know, whenever two trees grow in adjacent cells, they hinder each other's growth. Therefore, Devu would never plant a tree into a cell that is already adjacent to a cell with a tree. (This is also true for all the trees already present in his garden.)

Given the above rule, Devu wants to plant as many additional trees as possible. Return the largest possible number of trees Devu can have in his garden at the end.
Definition
    
Constraints
-
N will be between 1 and 50, inclusive.
-
garden will contain exactly 2 elements.
-
Each element of garden will contain exactly N characters.
-
Each character of each element of garden will be either '.' or '*'.
-
No two of the already planted trees are in adjacent cells.
Examples
0)

    
{"..", ".."}
Returns: 1
You can plant a single tree in either of the four available cells.
1)

    
{"..", ".*"}
Returns: 1
You cannot plant any additional trees.
2)

    
{"...",
"..*"}
Returns: 2
The garden already contains one tree in a corner. One optimal solution is to plant one additional tree in the opposite corner.
3)

    
{".....*..........",
".*.......*.*..*."}
Returns: 7

4)

    
{"....*.*.*...........*........",
"*..........*..*.*.*....*...*."}
Returns: 13

5)

    
{".....*..*..........*............................*",
"*..*.............*...*.*.*.*..*.....*.*...*...*.."}
Returns: 23
*/

public class DevuAndPlantingTrees {
    public int maximumTreesDevuCanGrow(String[] garden) {
        int len = garden[0].length();
        char[] line1 = garden[0].toCharArray();
        char[] line2 = garden[1].toCharArray();
        int count = 0;
        
        for (int i = 0; i < len; ) {
            if (line1[i] == '*' || line2[i] == '*') {
                count++;
                i += 2;
            } else {
                boolean poss = true;
                if (i > 0) {
                    if (line1[i-1] == '*' || line2[i-1] == '*')
                        poss = false;
                }
                if (i + 1< len) {
                    if (line1[i+1] == '*' || line2[i+1] == '*')
                        poss = false;
                }
                
                if (poss) {
                	line1[i] = '*';
                	count++;
                }
                
                i++;
            }
        }
        
        return count;
    }
}
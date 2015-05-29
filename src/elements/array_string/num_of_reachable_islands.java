/*
Problem Statement
    
Filip the Frog lives on a number line. There are islands at some points on the number line. You are given the positions of these islands in the int[] positions.  Filip starts on the island located at positions[0]. His maximal jump length is L, which means that he can jump to any island that is within a distance of L (inclusive) from his current location. Filip can't jump to a point on the number line that doesn't contain an island. He can make an unlimited number of jumps.  An island is reachable if Filip can get to it through some sequence of jumps. Please find and return the number of reachable islands.
Definition
    
Examples
0)

    
{4, 7, 1, 3, 5}
1
Returns: 3
Filip starts at position 4 and his maximal jump length is 1. He can reach the islands at positions 3, 4, and 5.
1)

    
{100, 101, 103, 105, 107}
2
Returns: 5
Here he can reach all 5 islands.
2)

    
{17, 10, 22, 14, 6, 1, 2, 3}
4
Returns: 7

3)

    
{0}
1000
Returns: 1
*/

public class FilipTheFrog {
    public int countReachableIslands(int[] positions, int L) {
        if (L == 0 || positions.length == 1) return 1;
        
        int start = positions[0];
        Arrays.sort(positions);
        start = Arrays.binarySearch(positions, start);
        
        int count = 1;
        int i = start + 1;
        int bound = positions[start] + L;
        
        while (i < positions.length && positions[i] <= bound) {
            count++;
            bound = Math.max(bound, positions[i] + L);
            i++;
        }
        
        i = start - 1;
        bound = positions[start] - L;
        while (i >= 0 && positions[i] >= bound) {
            count++;
            bound = Math.min(bound, positions[i] - L);
            i--;
        }
        
        return count;
    }
}
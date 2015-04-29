/*
Fence Painter

Write an algorithm that counts the number of ways you can paint a fence with N posts 
using K colors such that no more than 2 adjacent fence posts are painted with the same color.
*/

public int paintFence(int n, int k) {
    if (k == 0) return 0;
    
    int preDiff = k, diff = k * (k - 1);
    for (int i = 2; i < n; i++) {
        int currDiff = (k - 1) * (diff + preDiff);
        preDiff = diff;
        diff = currDiff;
    }
    
    return preDiff + diff;
}
/*
Given a rope of length n meters, cut the rope in different parts of integer lengths in a way that maximizes product of lengths of all parts. You must make at least one cut. Assume that the length of rope is more than 2 meters.
Examples:
Input: 2, return 1 because 1x1 = 1
Input: 5, return 6 because 2x3 = 6
*/

public int maxCutProd(int n) {
    if (n <= 1) return n;
    
    int[] prod = new int[n+1];
    prod[1] = 1;
    
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j < i; j++) {
            prod[i] = Math.max(prod[i], Math.max(prod[j] * (i - j), j * (i - j)));
        }
    }
    
    return prod[n];
}
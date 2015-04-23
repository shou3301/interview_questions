/*
Count the number of 1s in a 32-bit integer.
*/

// The simplest way.
public int numOfOnes(int x) {
    int c = 0;
    
    while (x != 0) {
        c += x & 1;
        x >>= 1;
    }
    
    return c;
}
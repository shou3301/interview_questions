/**
 * Count number of binary strings without consecutive 1s
 */
 
public int nonConsecutiveOnes(int N) {
    int[] z = new int[N];
    int[] o = new int[N];
    z[0] = 1;
    o[0] = 1;
    
    for (int i = 1; i < N; i++) {
        o[i] = z[i-1];
        z[i] = o[i-1] + z[i-1];
    }
    
    return o[N-1] + z[N-1];
}
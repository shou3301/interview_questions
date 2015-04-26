/*
Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence
1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
shows the first 11 ugly numbers. By convention, 1 is included.
Write a program to find and print the 150’th ugly number.
*/

public int[] getUglyNums(int n) {
    // index of pervious ugly number to mutiply by 2, 3 and 5.
    int i2 = 0, i3 = 0, i5 = 0;
    
    // the next ugly number to choose from
    int n2 = 2, n3 = 3, n5 = 5;
    int[] ugly = new int[n+1];
    ugly[0] = 1;
    
    for (int i = 1; i <= n; i++) {
        int res = Math.min(n2, Math.min(n3, n5));
        ugly[i] = res;
        
        if (res == n2) n2 = ugly[++i2] * 2;
        if (res == n3) n3 = ugly[++i3] * 3;
        if (res == n5) n5 = ugly[++i5] * 5;
    }
    
    return ugly;
}
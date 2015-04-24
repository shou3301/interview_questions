/*
给你一个array，返回array里面最大数字的index，
但是必须是最大数字里面随机的一个index。比如[2,1,2,1,5,4,5,5]必须返回[4,6,7]中的随机的一个数字，要求O(1)space。
*/


// return index
public int randomMax(int[] A) {
    int res = 0, count = 1, max = A[0];
    for (int i = 1; i < A.length; i++) {
        if (A[i] > max) {
            max = A[i];
            count = 1;
            res = i;
        } else if (A[i] == max) {
            if (new Random().nextInt(++count) == 0) res = i;
        }
    }
    
    return res;
}
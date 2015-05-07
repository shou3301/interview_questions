/*
Description
Given an integer, find the maximum integer by swapping any two digits.

Input
The input should be a non-negative integer less than 1010.

Output
The result should be in the format of Integer.

Sample Input
102
Sample Output
201
*/

class Solution {
	public int maximizeResult(int n) {
        if (n == 0) return 0;
        
        List<Integer> list = new ArrayList<>();
        while (n != 0) {
            list.add(n % 10);
            n /= 10;
        }
        
        if (list.size() == 1) return list.get(0);
        
        int[] left = new int[list.size()];
        left[0] = 0;
        for (int i = 1; i < left.length; i++) {
            left[i] = left[i-1];
            if (list.get(i) > list.get(left[i-1])) {
                left[i] = i;
            }
        }
        
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(left[i]) > list.get(i)) {
                int tmp = list.get(left[i]);
                list.set(left[i], list.get(i));
                list.set(i, tmp);
                break;
            }
        }
        
        int res = 0;
        int t = 1;
        for (int i = 0; i < list.size(); i++) {
            res += t * list.get(i);
            t *= 10;
        }
        
        return res;
	}
}
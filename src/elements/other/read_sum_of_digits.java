/*
Description
You are given a very large integer, read implementation of calculating the sum of digits.

Input
The input should be a non-negative integer less than 10100.

Output
 The result should be in the format of String with  {"zero","one","two","three","four","five","six","seven","eight","nine"}

Sample Input
987654321
Sample Output
four five
*/
class Solution {
	public String readSum(String n) {
        String[] map = new String[] {"zero","one","two","three","four","five","six","seven","eight","nine"};
        
        int sum = 0;
        for (int i = 0; i < n.length(); i++) {
            sum += n.charAt(i) - '0';
        }
        
        String res = "";
        if (sum == 0) return "zero";

        while (sum != 0) {
            res = map[sum % 10] + " " + res;
            sum /= 10;
        }
        
        return res.trim();
	}
}
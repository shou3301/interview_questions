/*
Description
 A little princess really likes playing the Palindromic Words Game. To play this, she follows the rules below:

(a) She is allowed to "reduce the value of a letter", meaning that she is allowed to change 'd' to 'c', but not for a change from 'c' to 'd'. 

(b) In order to form a palindrome word, if she has to repeatedly reduce the value of a letter, she can do it until the letter becomes 'a'. Once a letter has been changed to 'a', it can no longer be changed.

Each reduction in the value of any letter is counted as a single operation. Find the minimum number of operations required to convert a given word into a palindrome word. 

Input
 The input should be a string consists of lower-case letters in English. The length of the string should be less than or equal to 10,000.

Output
 The output should be the minimum number of operations.

Sample Input
aba
Sample Output
O
*/

class Solution {
	public int minimumOperations(String s) {
        if (s.length() <= 1) return 0;
        
        int c = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            c += Math.abs(s.charAt(i) - s.charAt(s.length() - 1 - i));
        }
        
        return c;
    }
}
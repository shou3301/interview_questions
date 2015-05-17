/*
Excel column to number
*/

public class Solution {
    public String convertToTitle(int n) {
        String res = "";
        while (n != 0) {
            int l = n % 26;
            if (l != 0) {
                res = String.valueOf((char)('A' + l - 1)) + res;
                n /= 26;
            } else {
                res = "Z" + res;
                n = (n - 26) / 26;
            }
        }
        
        return res;
    }
}

public class Solution {
    public int titleToNumber(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res * 26 + (s.charAt(i) - 'A' + 1);
        }
        
        return res;
    }
}
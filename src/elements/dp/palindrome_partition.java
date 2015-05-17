/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
*/

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s.length() == 0) {
            return res;
        }
        
        List<List<String>>[] memo = new ArrayList[s.length()];
        boolean[][] isPan = new boolean[s.length()][s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            memo[i] = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || isPan[j+1][i-1])) {
                    isPan[j][i] = true;
                    String curr = s.substring(j, i + 1);
                    if (j == 0) {
                        List<String> l = new ArrayList<>();
                        l.add(curr);
                        memo[i].add(l);
                    } else {
                        for (List<String> l : memo[j-1]) {
                            List<String> nl = new ArrayList<>(l);
                            nl.add(curr);
                            memo[i].add(nl);
                        }
                    }
                }
            }
        }
        
        return memo[s.length() - 1];
    }
}
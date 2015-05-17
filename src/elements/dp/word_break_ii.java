/*
Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
*/

public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (s.length() == 0 || wordDict.isEmpty()) return res;
        if (!isBreakable(s, wordDict)) return res;
        
        List<String>[] memo = new ArrayList[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            memo[i] = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                String curr = s.substring(j, i+1);
                if (wordDict.contains(curr)) {
                    if (j == 0) {
                        memo[i].add(curr);
                    } else {
                        for (String str : memo[j-1]) {
                            memo[i].add(str + " " + curr);
                        }
                    }
                }
            }
        }
        
        return memo[s.length() - 1];
    }
    
    public boolean isBreakable(String s, Set<String> wordDict) {
        boolean[] poss = new boolean[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (wordDict.contains(s.substring(j, i+1)) && (j == 0 || poss[j-1]))
                    poss[i] = true;
            }
        }
        
        return poss[s.length() - 1];
    }
}
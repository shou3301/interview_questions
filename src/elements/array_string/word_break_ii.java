public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (wordDict.isEmpty() || s.length() == 0) return res;
        if (!isBreakable(s, wordDict)) return res;
        
        List<String>[] memo = new ArrayList[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            memo[i] = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                String curr = s.substring(j, i+1);
                if (wordDict.contains(curr)) {
                    if (j > 0) {
                        for (String pre : memo[j-1]) {
                            memo[i].add(pre + " " + curr);
                        }
                    } else {
                        memo[i].add(curr);
                    }
                }
            }
        }
        
        return memo[s.length() - 1];
    }
    
    private boolean isBreakable(String s, Set<String> wordDict) {
        boolean[] breakable = new boolean[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            breakable[i] = wordDict.contains(s.substring(0, i+1));
            if (breakable[i]) continue;
            for (int j = 1; j <= i; j++) {
                breakable[i] = breakable[j-1] && wordDict.contains(s.substring(j, i + 1));
                if (breakable[i]) break;
            }
        }
        
        return breakable[s.length() - 1];
    }
}
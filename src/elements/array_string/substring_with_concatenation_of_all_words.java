/*
Substring with Concatenation of All Words

You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).

*/
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (words.length == 0) return res;
        
        int wLen = words[0].length();
        int tLen = wLen * words.length;
        Map<String, Integer> count = new HashMap<>();
        for (String w : words) {
            if (count.containsKey(w)) {
                count.put(w, count.get(w) + 1);
            } else {
                count.put(w, 1);
            }
        }
        
        for (int i = 0; i < wLen; i++) {
            Map<String, Integer> local = new HashMap<>();
            int num = 0;
            for (int j = i, k = i; j + wLen <= s.length(); j += wLen) {
                String curr = s.substring(j, j + wLen);
                if (count.containsKey(curr)) {
                    if (local.containsKey(curr)) {
                        local.put(curr, local.get(curr) + 1);
                    } else {
                        local.put(curr, 1);
                    }
                    
                    if (local.get(curr) <= count.get(curr)) {
                        num++;
                    } else {
                        while (local.get(curr) > count.get(curr)) {
                            String toRemove = s.substring(k, k + wLen);
                            local.put(toRemove, local.get(toRemove) - 1);
                            // This if statement is very important!
                            if (local.get(toRemove) < count.get(toRemove)) num--;
                            k += wLen;
                        }
                    }
                        
                    if (num == words.length) {
                        res.add(k);
                    }
                } else {
                    local.clear();
                    k = j + wLen;
                    num = 0;
                }
            }
        }
        
        return res;
    }
}
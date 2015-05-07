/*
Given a string, find the length of the longest substring without repeating characters. 
For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                res = Math.max(res, map.size());
                int k = map.get(s.charAt(i));
                while (j <= k) {
                    map.remove(s.charAt(j++));
                }
            }
            map.put(s.charAt(i), i);
        }
        
        return Math.max(res, map.size());
    }
}
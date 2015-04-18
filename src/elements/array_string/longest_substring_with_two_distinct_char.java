/**
 * Longest substring with at most two distinct chars
 */
 
public class Solution {
    
    public int longestTwoCharString(String str) {
        Map<Character, Integer> count = new HashMap<>();
        
        int res = 2;
        
        for (int i = 0, j = 0; i < str.length(); i++) {
            if (count.containsKey(str.charAt(i))) {
                count.put(str.charAt(i), count.get(str.charAt(i)) + 1);
            } else if (count.size() < 2) {
                count.put(str.charAt(i), 1);
            } else {
                res = Math.max(res, i - j);
                while (j < i && count.size() >= 2) {
                    if (count.containsKey(str.charAt(j))) {
                        count.put(str.charAt(j), count.get(str.charAt(j)) - 1);
                        if (count.get(str.charAt(j)) == 0) {
                            count.remove(str.charAt(j));
                        }
                        j++;
                    }
                }
                // add the new char
                count.put(str.charAt(i), 1);
            }
        }
        
        return res;
    }
    
}
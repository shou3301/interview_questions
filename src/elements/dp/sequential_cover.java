/**
 * Smallest subarray sequentially covering the set.
 * All elements in the set are unique.
 */
 
class Solution {
    
    public String minSequtentialWindow(String S, String T) {
        if (S == null || T == null || S.length() == 0 || T.length() == 0) return "";
        
        Map<Character, Integer> index = new HashMap<>();
        int[] latest = new int[T.length()];
        int[] minLen = new int[T.length()];
        
        Arrays.fill(latest, -1);
        Arrays.fill(minLen, Integer.MAX_VALUE);
        for (int i = 0; i < T.length(); i++) {
            index.put(T.charAt(i), i);
        }
        
        String res = "";
        int resLen = Integer.MAX_VALUE;
        for (int i = 0; i < S.length(); i++) {
            if (index.containsKey(S.charAt(i))) {
                int idx = index.get(S.charAt(i));
                if (idx == 0) {
                    minLen[idx] = 1;
                } else if (minLen[idx - 1] != Integer.MAX_VALUE) {
                    minLen[idx] = i - latest[idx - 1] + minLen[idx - 1];
                }
                
                latest[idx] = i;
                
                if (idx == T.length() - 1 && minLen[idx] < resLen) {
                    resLen = minLen[idx];
                    res = S.substring(i - resLen + 1, i + 1);
                }
            }
        }
        
        return res;
    }
    
}
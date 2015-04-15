/**
 * Smallest subarray sequentially covering the set.
 * All elements in the set are unique.
 */
 
class Solution {
    
    public String smallestCover(String S, String T) {
        if (S == null || T == null || S.length() == 0 || T.length() == 0) return "";
        
        // The most recent appreance of T[i] in S
        int[] latest = new int[T.length()];
        // The shortest length of the subarray in S that covers T[0...i]
        int[] size = new int[T.length()];
        
        Arrays.fill(latest, -1);
        Arrays.fill(size, Integer.MAX_VALUE);
        
        Map<Character, Integer> index = new HashMap<>();
        for (int i = 0; i < T.length(); i++) {
            index.put(T.charAt(i), i);
        }
        
        int min = Integer.MAX_VALUE;
        String res = "";
        for (int i = 0; i < S.length(); i++) {
            if (index.containsKey(S.charAt(i))) {
                int idx = index.get(S.charAt(i));
                if (idx == 0) {
                    size[0] = 1;
                } else if (size[idx - 1] != Integer.MAX_VALUE) {
                    size[idx] = i - latest[idx - 1] + size[idx - 1];
                }
            }
            
            latest[idx] = i;
            
            if (idx == T.length() - 1 && size[idx] < min) {
                min = size[idx];
                res = S.substring(latest[idx] - min + 1, latest[idx] + 1);
            }
        }
        
        return res;
    }
    
}
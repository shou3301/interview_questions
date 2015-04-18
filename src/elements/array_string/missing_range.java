/**
 * Missing ranges. Given a sorted integer array where the range is [0, 99], return its missing ranges
 */
 
public class Solution {
    
    public List<String> missingRanges(int[] A) {
        List<String> res = new ArrayList<>();
        
        for (int i = 0; i < A.length; i++) {
            if (i == 0 && A[i] != 0) {
                if (A[i] - 1 == 0) {
                    res.add("0");
                } else {
                    res.add("0->" + (A[i]-1));
                }
            } else {
                if (A[i] - A[i-1] > 1) {
                    if (A[i-1] + 1 == A[i] - 1) {
                        res.add(A[i] - 1);
                    } else {
                        res.add((A[i-1] + 1) + "->" + (A[i] - 1));
                    }
                }
            }
        }
        
        if (A[A.length - 1] != 99) {
            if (A[A.length - 1] == 98) {
                res.add("99");
            } else {
                res.add((A[A.length - 1] + 1) + "->99");
            }
        }
        
        return res;
    }
    
}
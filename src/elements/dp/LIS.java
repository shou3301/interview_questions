/**
 * LIS problem O(nlogn) - actually it's non-decreasing
 * Be careful with the difference between increasing seq or non-decreasing seq
 */
class Solution {
    public int longestIncreasingSubseq(int[] A) {
        ArrayList<Integer> tails = new ArrayList<>();
        
        for (int i = 0; i < A.length; i++) {
            if (tails.isEmpty() || A[i] >= tails.get(tails.size() - 1)) {
                tails.add(A[i]);
            } else {
                int idx = searchUpperBond(tails, 0, tails.size(), A[i]);
                tails.set(idx, A[i]);
            }
        }
        
        return tails.size();
    }
    
    private int searchUpperBond(ArrayList<Integer> list, int s, int e, int target) {
        if (s == e){
            if (list.get(s) < target) {
                return s + 1;
            } else {
                return s;
            }
        }
        
        int m = (s + e) / 2;
        
        if (list.get(m) < target) {
            return searchUpperBond(list, m + 1, e, target);
        } else {
            return searchUpperBond(list, s, m);
        }
    }
}
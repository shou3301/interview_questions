/*
Find all possible combinations of k numbers that add up to a number n, 
given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
*/

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        bt(new ArrayList<Integer>(), 0, k, n, res);
        return res;
    }
    
    private void bt(List<Integer> buffer, int sum, int k, int target, List<List<Integer>> res) {
        if (k == 0 && sum == target) {
            res.add(new ArrayList<Integer>(buffer));
            return;
        }
        
        if (k == 0) return;
        
        int base = 0;
        if (buffer.size() > 0) {
            base = buffer.get(buffer.size() - 1);
        }
        
        for (int i = base + 1; i <= 9; i++) {
            buffer.add(i);
            bt(buffer, sum + i, k - 1, target, res);
            buffer.remove(buffer.size() - 1);
        }
    }
}
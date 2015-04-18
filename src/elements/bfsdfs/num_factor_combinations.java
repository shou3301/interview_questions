/**
 * Print all unique combination of factors (except 1) of a given number.
 */

public List<List<Integer>> getFactorCombinations(int N) {
    // Assume N > 1
    List<List<Integer>> res = new ArrayList<>();
    find(new ArrayList<Integer>(), N, res);
    
    return res;
}

public void find(List<Integer> buffer, int N, List<List<Integer>> res) {
    if (N == 1) {
        // Check size to make sure we don't add N itself as a factor.
        if (buffer.size() > 1)
            res.add(new ArrayList<Integer>(buffer));
        return;
    }
    
    // This prevents us from adding duplicated answers.
    int start = buffer.isEmpty() ? 2 : buffer.get(buffer.size() - 1);
    for (int i = start; i <= N; i++) {
        if (N % i == 0) {
            buffer.add(i);
            find(buffer, N / i, res);
            buffer.remove(buffer.size() - 1);
        }
    }
}
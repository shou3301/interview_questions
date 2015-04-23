/*
给了a, b, c三个vector<string>，要求求出数组的Combination，每一个vector中选一个，为空则不选，不用考虑duplicate
*/

public Set<List<Integer>> arrayCombination(List<List<Integer>> lists) {
    res = new HashSet<>();
    backtracking(new ArrayList<Integer>(), 0, lists);
}

Set<List<Integer>> res;

public void backtracking(List<Integer> buffer, int listIndex, List<List<Integer>> lists) {
    if (listIndex == lists.size()) {
        res.add(new ArrayList<Integer>(buffer));
        return;
    }
    
    for (Integer i : lists.get(index)) {
        buffer.add(i);
        backtracking(buffer, listIndex + 1, lists);
        buffer.remove(buffer.size() - 1);
    }
}
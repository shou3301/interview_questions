/*
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
*/
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return true;
        Queue<Integer> q = new LinkedList<>();
        
        Map<Integer, Integer> income = new HashMap<>();
        Map<Integer, List<Integer>> edge = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            income.put(i, 0);
            edge.put(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            income.put(prerequisites[i][0], income.get(prerequisites[i][0]) + 1);
            edge.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (income.get(i) == 0) q.offer(i);
        }
        
        Set<Integer> res = new HashSet<>();
        while (!q.isEmpty()) {
            int curr = q.poll();
            res.add(curr);
            for (Integer o : edge.get(curr)) {
                if (!res.contains(o)) {
                    income.put(o, income.get(o) - 1);
                    if (income.get(o) == 0) q.offer(o);
                }
            }
        }
        
        return res.size() == numCourses;
    }
}
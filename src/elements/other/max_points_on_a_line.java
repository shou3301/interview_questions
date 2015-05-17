/*
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
*/

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        int res = 0;
        if (points.length == 0) return res;
        
        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> count = new HashMap<>();
            int verticle = 0;
            int same = 0;
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    if (points[i].x == points[j].x && points[i].y == points[j].y) {
                        same++;
                    } else if (points[i].y == points[j].y) {
                        verticle++;
                    } else {
                        double r = (points[i].x - points[j].x) * 1.0 / (points[i].y - points[j].y) * 1.0;
                        if (count.containsKey(r)) {
                            count.put(r, count.get(r) + 1);
                        } else {
                            count.put(r, 1);
                        }
                    }
                }
            }
            
            for (Double r : count.keySet()) {
                res = Math.max(res, count.get(r) + same);
            }
            res = Math.max(res, verticle + same);
        }
        
        return res + 1;
    }
}
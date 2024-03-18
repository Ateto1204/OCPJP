/**
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons
 * Problem ID: 452. Minimum Number of Arrows to Burst Balloons
 *
 * Author: Ateto
 */

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[1] == b[1]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            }
        });
        int sum = 0;
        int q = points[0][1];
        int n = points.length;
        for(int i = 1; i < n; i++) {
            if(points[i][0] > q) {
                sum++;
                q = points[i][1];
            }
        }
        sum++;
        return sum;
    }
}
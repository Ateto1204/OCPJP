/**
 * https://leetcode.com/problems/insert-interval
 * Problem ID: 57. Insert Interval
 *
 * Author: Ateto
 */

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> tmp = new ArrayList();
        int n = intervals.length;
        if(n == 0) {
            int[][] dummy = new int[1][2];
            dummy[0][0] = new Interval[0];
            dummy[0][1] = new Interval[1];
            return dummy;
        }

        int p = intervals[0][0];
        int q = intervals[0][1];
        boolean used = false;

        if(newInterval[1] <= q) {
            if(newInterval[1] >= p) {
                p = Integer.min(p, newInterval[0]);
            } else {
                int[] dummy = {newInterval[0], newInterval[1]};
                tmp.add(dummy);
            }
            used = true;
        } else if(newInterval[0] <= p) {
            p = Integer.min(p, newInterval[0]);
            q = Integer.max(q, newInterval[1]);
            used = true;
        }

        for(int i = 1; i < n; i++) {
            if(!used) {
                if(newInterval[0] >= p && newInterval[1] <= intervals[i][1]) {
                    if(newInterval[0] > q) {
                        int[] dummy = {p, q};
                        tmp.add(dummy);
                        if(newInterval[1] < intervals[i][0]) {
                            int[] dummy2 = {newInterval[0], newInterval[1]};
                            tmp.add(dummy2);
                            p = intervals[i][0];
                        } else {
                            p = newInterval[0];
                        }
                        q = intervals[i][1];
                    } else {
                        if(newInterval[1] < intervals[i][0]) {
                            int[] dummy = {p, newInterval[1]};
                            tmp.add(dummy);
                            p = intervals[i][0];
                        }
                        q = intervals[i][1];
                    }
                    used = true;
                } else if(newInterval[0] <= q) {
                    p = Integer.min(p, newInterval[0]);
                    q = Integer.max(q, newInterval[1]);
                    used = true;
                }
            }
            if(intervals[i][0] <= q) {
                p = Integer.min(p, intervals[i][0]);
                q = Integer.max(q, intervals[i][1]);
            } else {
                int[] dummy = {p, q};
                tmp.add(dummy);
                p = intervals[i][0];
                q = intervals[i][1];
            }
        }
        if(!used) {
            if(newInterval[0] <= q) {
                p = Integer.min(p, newInterval[0]);
                q = Integer.max(q, newInterval[1]);
            } else {
                int[] dummy = {p, q};
                tmp.add(dummy);
                p = newInterval[0];
                q = newInterval[1];
            }
        }
        int[] dummy = {p, q};
        tmp.add(dummy);
        n = tmp.size();
        int[][] result = new int[n][2];
        for(int i = 0; i < n; i++) {
            result[i] = tmp.get(i);
        }
        return result;
    }
}
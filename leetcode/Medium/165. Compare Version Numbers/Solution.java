/**
 * https://leetcode.com/problems/compare-version-numbers
 * Problem ID: 165. Compare Version Numbers
 *
 * Author: Ateto
 */

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] x = version1.split("\\.");
        String[] y = version2.split("\\.");
        int n = Integer.max(x.length, y.length);
        for (int i = 0; i < n; i++) {
            int a = i >= x.length ? 0 : Integer.valueOf(x[i]);
            int b = i >= y.length ? 0 : Integer.valueOf(y[i]);
            if (a > b) return 1;
            if (b > a) return -1;
        }
        return 0;
    }
}
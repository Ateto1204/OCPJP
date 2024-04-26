/**
 * https://leetcode.com/problems/minimum-falling-path-sum-ii
 * Problem ID: 1289. Minimum Falling Path Sum II
 *
 * Author: Ateto
 */

class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = grid[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean first = true;
                for (int k = 0; k < n; k++) {
                    if (j == k) continue;
                    if (first) {
                        dp[i][j] = dp[i-1][k] + grid[i][j];
                        first = false;
                    }
                    dp[i][j] = Integer.min(dp[i][j], dp[i-1][k] + grid[i][j]);
                }
            }
        }
        int result = dp[n-1][0];
        for (int i = 1; i < n; i++) {
            result = Integer.min(result, dp[n-1][i]);
        }
        return result;
    }
}
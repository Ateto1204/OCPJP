/**
 * https://leetcode.com/problems/longest-ideal-subsequence
 * Problem ID: 2370. Longest Ideal Subsequence
 *
 * Author: Ateto
 */

class Solution {
    final int N = 26;

    private int abs(int x) {
        if (x < 0) return -x;
        return x;
    }

    public int longestIdealString(String s, int k) {
        int n = s.length();
        int[] dp = new int[N];
        int result = 0;
        for (int i = 0; i < n; i++) {
            int u = s.charAt(i) - 'a';
            int tmp = 0;
            for (int j = 0; j < N; j++) {
                if (abs(j-u) <= k) {
                    tmp = Integer.max(tmp, dp[j]);
                }
            }
            dp[u] = tmp + 1;
        }
        for (int num : dp) {
            result = Integer.max(result, num);
        }
        return result;
    }
}
/**
 * https://leetcode.com/problems/freedom-trail
 * Problem ID: 514. Freedom Trail
 *
 * Author: Ateto
 */

class Solution {
    private char[] r;
    private List<Integer>[] positions;
    private int[][] dp;

    private int solve(int idx, int pos, char[] key) {
        if (idx == key.length) return 0;
        if (dp[idx][pos] > 0) return dp[idx][pos];
        char target = key[idx];
        List<Integer> possiblePositions = positions[target - 'a'];
        int mn = Integer.MAX_VALUE;
        for (int nxt : possiblePositions) {
            int steps = Math.min(Math.abs(nxt - pos), r.length - Math.abs(nxt - pos));
            int totalSteps = steps + solve(idx+1, nxt, key);
            mn = Math.min(mn, totalSteps);
        }
        dp[idx][pos] = mn + 1;
        return dp[idx][pos];
    }

    public int findRotateSteps(String ring, String key) {
        r = ring.toCharArray();
        positions = new List[26];
        dp = new int[key.length()][r.length];
        for (int i = 0; i < r.length; i++) {
            int c = r[i] - 'a';
            if (positions[c] == null) {
                positions[c] = new ArrayList<>();
            }
            positions[c].add(i);
        }
        int result = solve(0, 0, key.toCharArray());
        return result;
    }
}
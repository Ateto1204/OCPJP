/*
 *
 * https://leetcode.com/problems/relative-ranks
 * Problem ID: 506. Relative Ranks
 * 
 * Author: Ateto
 * 
 */

class Solution {
    public String[] findRelativeRanks(int[] score) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] order = score.clone();
        Arrays.sort(order);
        int n = score.length;
        for (int i = n-1; i >= 0; i--) {
            map.put(order[i], n-i-1);
        }
        String[] result = new String[n];
        int idx = 0;
        for (int i : score) {
            int rank = map.get(i);
            if (rank == 0) {
                result[idx] = "Gold Medal";
            } else if (rank == 1) {
                result[idx] = "Silver Medal";
            } else if (rank == 2) {
                result[idx] = "Bronze Medal";
            } else {
                String str = Integer.toString(rank+1);
                result[idx] = str;
            }
            idx++;
        }
        return result;
    }
}
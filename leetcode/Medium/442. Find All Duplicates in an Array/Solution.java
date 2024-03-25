/*
 *
 * https://leetcode.com/problems/find-all-duplicates-in-an-array
 * Problem ID: 442. Find All Duplicates in an Array
 *
 * Author: Ateto
 *
 */

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        boolean[] used = new boolean[n + 1];
        for(int i = 0; i < n; i++) {
            if(used[nums[i]]) {
                result.add(nums[i]);
            }
            used[nums[i]] = true;
        }
        return result;
    }
}
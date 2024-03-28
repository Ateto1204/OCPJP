/**
 * https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency
 * Problem ID: 2958. Length of Longest Subarray With at Most K Frequency
 *
 * Author: Ateto
 */

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int left = 0;
        int right = 0;
        int result = 0;
        while(right < n) {
            int cur = nums[right];
            right++;
            if(!map.containsKey(cur)) {
                map.put(cur, 1);
            } else {
                int dummy = map.get(cur);
                map.replace(cur, dummy + 1);
            }
            while(left < right && map.get(cur) > k) {
                int dummy = nums[left];
                left++;
                int value = map.get(dummy);
                map.replace(dummy, value - 1);
            }
            result = Integer.max(result, right - left);
        }
        return result;
    }
}
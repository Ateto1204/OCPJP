/**
 * https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times
 * Problem ID: 2962. Count Subarrays Where Max Element Appears at Least K Times
 *
 * Author: Ateto
 */

class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = 0;
        for(int num : nums) {
            max = Integer.max(max, num);
        }
        int left = 0;
        int right = 0;
        long result = 0;
        int n = nums.length;
        int count = 0;
        while(right < n || left > right) {
            if(nums[right] == max) count++;
            while(count >= k) {
                if(nums[left] == max) count--;
                result += n - right;
                left++;
            }
            right++;
        }
        return result;
    }
}
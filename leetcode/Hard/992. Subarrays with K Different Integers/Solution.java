/**
 * https://leetcode.com/problems/subarrays-with-k-different-integers
 * Problem ID: 992. Subarrays with K Different Integers
 *
 * Author: Ateto
 */

class Solution {
    private int solve(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int p = 0;
        int q = 0;
        int n = nums.length;
        int result = 0;
        while(q < n) {
            int tmp = nums[q];
            if(map.containsKey(tmp)) {
                int dummy = map.get(tmp);
                map.replace(tmp, dummy + 1);
            } else {
                map.put(tmp, 1);
            }
            if(map.get(tmp) == 1) {
                count++;
            }
            while(count > k) {
                tmp = nums[p];
                int dummy = map.get(tmp);
                map.replace(tmp, dummy - 1);
                if(map.get(tmp) == 0) {
                    count--;
                }
                p++;
            }
            result += q - p + 1;
            q++;
        }
        return result;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        int x = solve(nums, k);
        int y = solve(nums, k - 1);
        int result = x - y;
        return result;
    }
}
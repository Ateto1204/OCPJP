/**
 * https://leetcode.com/problems/contiguous-array
 * Problem ID: 525. Contiguous Array
 *
 * Author: Ateto
 */

class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap();
        int sum = 0;
        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] == 0) sum--;
            else sum++;
            if(sum == 0) ans = i + 1;
            else if(map.containsKey(sum)) {
                ans = Integer.max(ans, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return ans;
    }
}
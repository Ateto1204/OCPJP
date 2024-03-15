/**
 * https://leetcode.com/problems/product-of-array-except-self/
 * Problem ID: 238. Product of Array Except Self
 *
 * Author: Ateto
 */

 class Solution {
    private final int MAXN = 100005;
    private int prefix[] = new int[MAXN];
    private int suffix[] = new int[MAXN];

    private void init(int[] nums) {
        prefix[0] = 1;
        for(int i = 1; i <= nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        suffix[0] = 1;
        for(int i = 1; i <= nums.length; i++) {
            suffix[i] = suffix[i - 1] * nums[nums.length - i];
        }
    }

    public int[] productExceptSelf(int[] nums) {
        int result[] = new int[nums.length];
        init(nums);
        for(int i = 0; i < nums.length; i++) {
            int tmp;
            if(i == 0) {
                tmp = suffix[nums.length - 1];
            } else if(i == nums.length - 1) {
                tmp = prefix[nums.length - 1];
            } else {
                tmp = prefix[i] * suffix[nums.length - i - 1];
            }
            result[i] = tmp;
        }
        return result;
    }
}
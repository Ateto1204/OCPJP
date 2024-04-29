/**
 * https://leetcode.com/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k
 * Problem ID: 2997. Minimum Number of Operations to Make Array XOR Equal to K
 *
 * Author: Ateto
 */

class Solution {
    public int minOperations(int[] nums, int k) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int count = 0;
        while (k > 0 || xor > 0) {
            if ((k&1) != (xor&1)) {
                count++;
            }
            k >>= 1;
            xor >>= 1;
        }
        return count;
    }
}
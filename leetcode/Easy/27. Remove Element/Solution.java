/**
 * https://leetcode.com/problems/remove-element/
 * Problem ID: 27. Remove Element
 *
 * Author: Ateto
 */

class Solution {
    public int removeElement(int[] nums, int val) {
        int count = nums.length;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == val) {
                count--;
            }
        }
        int[] dummy = new int[count];
        for(int i = 0, idx = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                dummy[idx] = nums[i];
                idx++;
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(i < count) {
                nums[i] = dummy[i];
            }
        }
        return count;
    }
}
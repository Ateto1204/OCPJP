/*
 *
 * https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses
 * Problem ID: 1614. Maximum Nesting Depth of the Parentheses
 * 
 * Author: Ateto
 * 
 */

class Solution {
    public int maxDepth(String s) {
        int idx = 0;
        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                idx++;
                result = Integer.max(result, idx);
            } else if(s.charAt(i) == ')') {
                idx--;
            }
        }
        return result;
    }
}
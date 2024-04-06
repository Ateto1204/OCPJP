/*
 *
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses
 * Problem ID: 1249. Minimum Remove to Make Valid Parentheses
 * 
 * Author: Ateto
 * 
 */

class Solution {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        int count = 0;
        List<Integer> stack = new ArrayList<>();
        List<Integer> invalid = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                stack.add(count);
                count++;
            } else if(ch == ')') {
                if(stack.isEmpty()) {
                    invalid.add(count);
                    count++;
                    continue;
                }
                int k = stack.size();
                stack.remove(k-1);
                count++;
            }
        }
        StringBuilder result = new StringBuilder();
        count = 0;
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == ')') {
                count++;
                if (stack.contains(count-1)) {
                    continue;
                }
                if (invalid.contains(count-1)) {
                    continue;
                }
            }
            result.append(ch);
        }
        return result.toString();
    }
}
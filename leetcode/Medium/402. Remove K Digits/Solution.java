/*
 *
 * https://leetcode.com/problems/remove-k-digits
 * Problem ID: 402. Remove K Digits
 *
 * Author: Ateto
 *
 */

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        result.reverse();
        while (result.length() > 0 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        if (result.length() > 0) {
            return result.toString();
        }
        return "0";
    }
}
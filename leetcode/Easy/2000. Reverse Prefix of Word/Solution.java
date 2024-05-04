/**
 * https://leetcode.com/problems/reverse-prefix-of-word
 * Problem ID: 2000. Reverse Prefix of Word
 *
 * Author: Ateto
 */

class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder builder = new StringBuilder();
        int n = word.length();
        int reversePosition = -1;
        for (int i = 0; i < n; i++) {
            char now = word.charAt(i);
            if (now == ch) {
                reversePosition = i;
                break;
            }
        }
        for (int i = reversePosition; i >= 0; i--) {
            char now = word.charAt(i);
            builder.append(now);
        }
        for (int i = reversePosition+1; i < n; i++) {
            char now = word.charAt(i);
            builder.append(now);
        }
        String result = builder.toString();
        return result;
    }
}
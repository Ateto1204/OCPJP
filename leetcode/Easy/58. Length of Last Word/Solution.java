/*
 *
 * https://leetcode.com/problems/length-of-last-word
 * Problem ID: 58. Length of Last Word
 *
 * Author: Ateto
 *
 */

class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int i = n - 1;
        while(i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        int j = i - 1;
        while(j >= 0 && s.charAt(j) != ' ') {
            j--;
        }
        return i - j;
    }
}
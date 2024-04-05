/*
 *
 * https://leetcode.com/problems/make-the-string-great
 * Problem ID: 1544. Make The String Great
 * 
 * Author: Ateto
 * 
 */

class Solution {
    private void solve(StringBuilder str, char b) {
        int n = str.length();
        char a = str.charAt(n-1);
        char saved = b;
        if(a > b) {
            char tmp = a;
            a = b;
            b = tmp;
        }
        if(a+32 == b) {
            str.deleteCharAt(n-1);
            return ;
        }
        str.append(saved);
    }
    public String makeGood(String s) {
        StringBuilder result = new StringBuilder();
        int n = s.length();
        for(int i = 0; i < n; i++) {
            if(result.isEmpty()) {
                result.append(s.charAt(i));
                continue;
            }
            solve(result, s.charAt(i));
        }
        return result.toString();
    }
}
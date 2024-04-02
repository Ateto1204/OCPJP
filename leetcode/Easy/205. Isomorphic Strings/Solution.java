/*
 *
 * https://leetcode.com/problems/isomorphic-strings
 * Problem ID: 205. Isomorphic Strings
 *
 * Author: Ateto
 *
 */

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] a = new int[129];
        int[] b = new int[129];
        for(int i = 0; i < 129; i++) {
            a[i] = -1;
            b[i] = -1;
        }
        for(int i = 0; i < s.length(); i++) {
            int x = s.charAt(i);
            int y = t.charAt(i);
            if(a[x] == -1 && b[y] == -1) {
                a[x] = y;
                b[y] = x;
            } else if(a[x] != y || b[y] != x) {
                return false;
            }
        }
        return true;
    }
}
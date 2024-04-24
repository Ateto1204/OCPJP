/**
 * https://leetcode.com/problems/n-th-tribonacci-number
 * Problem ID: 1137. N-th Tribonacci Number
 *
 * Author: Ateto
 */

class Solution {
    public int tribonacci(int n) {
        int a = 0;
        int b = 1;
        int c = 1;
        if (n == 0) return 0;
        if (n <= 2) return 1;
        for (int i = 0; i < n-2; i++) {
            int saved = a + b + c;
            a = b;
            b = c;
            c = saved;
        }
        return c;
    }
}
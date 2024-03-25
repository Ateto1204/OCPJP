/**
 * https://leetcode.com/problems/powx-n
 * Problem ID: 50. Pow(x, n)
 *
 * Author: Ateto
 */

class Solution {
    public double myPow(double x, int n) {
        double sum = 1.0;
        double i;
        long j = n;
        if(j < 0) j *= -1;
        for(i = x; j > 0; i *= i, j >>= 1) {
            if((j & 1) == 1) {
                sum *= i;
            }
        }
        if(n < 0) return 1.0 / sum;
        return sum;
    }
}
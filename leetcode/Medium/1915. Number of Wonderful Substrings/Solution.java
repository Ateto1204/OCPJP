/**
 * https://leetcode.com/problems/number-of-wonderful-substrings
 * Problem ID: 1915. Number of Wonderful Substrings
 *
 * Author: Ateto
 */

class Solution {
    public long wonderfulSubstrings(String word) {
        long[] count = new long[1<<10];
        long result = 0;
        int prefixXor = 0;
        count[prefixXor] = 1;

        for (char ch : word.toCharArray()) {
            int charIndex = ch - 'a';
            prefixXor ^= 1 << charIndex;
            result += count[prefixXor];
            for (int i = 0; i < 10; i++) {
                result += count[prefixXor ^ (1 << i)];
            }
            count[prefixXor]++;
        }
        return result;
    }
}
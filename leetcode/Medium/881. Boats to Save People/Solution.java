/**
 * https://leetcode.com/problems/boats-to-save-people
 * Problem ID: 881. Boats to Save People
 *
 * Author: Ateto
 */

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int left = 0;
        int right = n - 1;
        int count = 0;
        while (left < right) {
            int sum = people[left] + people[right];
            if (sum > limit) {
                right--;
            } else {
                left++;
                right--;
            }
            count++;
        }
        if (left == right) count++;
        return count;
    }
}
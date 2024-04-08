/*
 *
 * https://leetcode.com/problems/number-of-students-unable-to-eat-lunch
 * Problem ID: 1700. Number of Students Unable to Eat Lunch
 * 
 * Author: Ateto
 * 
 */
 
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int a = 0;
        int b = 0;
        for (int student : students) {
            if (student == 0) {
                a++;
            } else if (student == 1) {
                b++;
            }
        }
        int n = sandwiches.length;
        for (int i = 0; i < n; i++) {
            if (sandwiches[i] == 0) {
                if (a == 0) return b;
                a--;
            } else if (sandwiches[i] == 1) {
                if (b == 0) return a;
                b--;
            }
        }
        return 0;
    }
}
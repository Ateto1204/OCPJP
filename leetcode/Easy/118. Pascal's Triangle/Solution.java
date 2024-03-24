/*
 *
 * https://leetcode.com/problems/pascals-triangle
 * Problem ID: 118. Pascal's Triangle
 *
 * Author: Ateto
 *
 */

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp;
        for(int i = 0; i < numRows; i++) {
            tmp = new ArrayList<>();
            tmp.add(1);
            if(i == 0) {
                result.add(tmp);
                continue;
            } else if(i > 1) {
                List<Integer> dummy = result.get(i - 1);
                int n = dummy.size();
                System.out.println(n);
                for(int j = 0; j < n - 1; j++) {
                    int num = dummy.get(j) + dummy.get(j + 1);
                    tmp.add(num);
                }
            }
            tmp.add(1);
            result.add(tmp);
        }
        return result;
    }
}
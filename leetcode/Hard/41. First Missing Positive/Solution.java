/**
 * https://leetcode.com/problems/first-missing-positive
 * Problem ID: 41. First Missing Positive
 *
 * Author: Ateto
 */

class Solution {
    public int firstMissingPositive(int[] nums) {
        Map<Integer, Boolean> map = new TreeMap<>();;
        for(int i : nums) {
            if(i > 0) {
                map.putIfAbsent(i, true);
            }
        }
        if(map.size() < 1) {
            return 1;
        }
        Iterator<Map.Entry<Integer, Boolean>> itr;
        itr = map.entrySet().iterator();
        int prev = itr.next().getKey();
        if(prev > 1) {
            return 1;
        }
        while(itr.hasNext()) {
            int cur = itr.next().getKey();
            if(cur - prev > 1) {
                return prev + 1;
            }
            prev = cur;
        }
        return prev + 1;
    }
}
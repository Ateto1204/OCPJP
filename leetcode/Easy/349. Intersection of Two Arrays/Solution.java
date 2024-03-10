/**
 * https://leetcode.com/problems/intersection-of-two-arrays/
 * Problem ID: 349. Intersection of Two Arrays
 *
 * Author: Ateto
 */

 class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> resultList = new ArrayList();
        int cnt1[] = new int[1001];
        int cnt2[] = new int[1001];
        for(int i=0; i<nums1.length; i++) {
            cnt1[nums1[i]]++;
        }
        for(int i=0; i<nums2.length; i++) {
            cnt2[nums2[i]]++;
        }
        for(int i=0; i<=1000; i++) {
            if(cnt1[i] > 0 && cnt2[i] > 0) {
                resultList.add(i);
            }
        }
        int result[] = new int[resultList.size()];
        for(int i=0; i<resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}
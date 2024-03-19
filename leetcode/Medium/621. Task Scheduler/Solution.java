/**
 * https://leetcode.com/problems/task-scheduler
 * Problem ID: 621. Task Scheduler
 *
 * Author: Ateto
 */

class Solution {
    public int leastInterval(char[] tasks, int n) {
        Integer freq[] = new Integer[26];
        for(int i = 0; i < 26; i++) freq[i] = 0;
        for(char c : tasks) {
            int idx = c - 'A';
            freq[idx]++;
        }
        Arrays.sort(freq, Collections.reverseOrder());
        int chunk = freq[0] - 1;
        int result = chunk * n;
        for(int i = 1; i < 26; i++) {
            result -= Integer.min(chunk, freq[i]);
        }
        if(result < 0) return tasks.length;
        return tasks.length + result;
    }
}
/**
 * https://leetcode.com/problems/reveal-cards-in-increasing-order
 * Problem ID: 950. Reveal Cards In Increasing Order
 *
 * Author: Ateto
 */

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int n = deck.length;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(deck[n-1]);
        for (int i = n-2; i >= 0; i--) {
            deque.addFirst(deque.removeLast());
            deque.addFirst(deck[i]);
        }
        int[] result = new int[n];
        int idx = 0;
        for (Integer e : deque) {
            result[idx] = e;
            idx++;
        }
        return result;
    }
}
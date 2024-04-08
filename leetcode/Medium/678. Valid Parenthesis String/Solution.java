/**
 * https://leetcode.com/problems/subarray-product-less-than-k
 * Problem ID: 678. Valid Parenthesis String
 *
 * Author: Ateto
 */

class Pair {
    char sign;
    int idx;
    public Pair(char sign, int idx) {
        this.sign = sign;
        this.idx = idx;
    }
}

class Solution {
    public boolean checkValidString(String s) {
        List<Pair> list = new ArrayList<>();
        List<Pair> stack = new ArrayList<>();
        Deque<Integer> star = new ArrayDeque<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == ')') {
                list.add(new Pair(ch, i));
            } else if (ch == '*') {
                star.add(i);
            }
        }
        for (Pair p : list) {
            if (p.sign == '(') {
                stack.add(p);
            } else if (p.sign == ')') {
                int last = stack.size();
                if (last > 0) {
                    stack.remove(last - 1);
                } else {
                    if (star.size() == 0) return false;
                    int cur = star.peek();
                    star.poll();
                    if (cur > p.idx) {
                        return false;
                    }
                }
            }
        }
        while(!stack.isEmpty()) {
            if(star.isEmpty()) break;
            int cur = star.peekLast();
            star.pollLast();
            int last = stack.size();
            Pair pair = stack.get(last - 1);
            if(cur < pair.idx) {
                return false;
            }
            stack.remove(last - 1);
        }
        return stack.isEmpty();
    }
}
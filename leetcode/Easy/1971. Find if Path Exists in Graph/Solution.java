/**
 * https://leetcode.com/problems/find-if-path-exists-in-graph
 * Problem ID: 1971. Find if Path Exists in Graph
 *
 * Author: Ateto
 */

class Solution {
    private int[] parent;
    private int[] size;
    
    private void init(int n) {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    private int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    private void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return ;
        if (size[x] < size[y]) {
            int tmp = x;
            x = y;
            y = tmp;
        }
        size[x] += size[y];
        parent[y] = x;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        parent = new int[n];
        size = new int[n];
        init(n);
        for (int[] edge: edges) {
            union(edge[0], edge[1]);
        }
        return find(source) == find(destination);
    }
}
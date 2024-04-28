/**
 * https://leetcode.com/problems/sum-of-distances-in-tree
 * Problem ID: 834. Sum of Distances in Tree
 *
 * Author: Ateto
 */

class Solution {
    private int[][] graph;
    private int[] count;
    private int[] result;
    private int N;

    private void dfs1(int cur, int parent) {
        count[cur] = 1;
        for (int child : graph[cur]) {
            if (child == parent) continue;
            dfs1(child, cur);
            count[cur] += count[child];
            result[cur] += result[child] + count[child];
        }
    }

    private void dfs2(int cur, int parent) {
        for (int child : graph[cur]) {
            if (child == parent) continue;
            result[child] = result[cur] + N - 2*count[child];
            dfs2(child, cur);
        }
    }

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.N = n;
        this.result = new int[N];
        this.graph = new int[N][];
        this.count = new int[N];

        for (int[] edge : edges) {
            count[edge[0]]++;
            count[edge[1]]++;
        }
        for (int i = 0; i < N; i++) {
            graph[i] = new int[count[i]];
        }
        for (int[] edge : edges) {
            count[edge[0]]--;
            graph[edge[0]][count[edge[0]]] = edge[1];
            count[edge[1]]--;
            graph[edge[1]][count[edge[1]]] = edge[0];
        }
        dfs1(0, -1); dfs2(0, -1);
        return result;
    }
}
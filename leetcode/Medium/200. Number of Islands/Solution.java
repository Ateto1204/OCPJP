/**
 * https://leetcode.com/problems/number-of-islands
 * Problem ID: 200. Number of Islands
 *
 * Author: Ateto
 */

class Solution {
    private class Pair {
        public final int x;
        public final int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private void bfs(int x, int y, char[][] grid, boolean[][] used) {
        int way[][] = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(x, y));
        used[x][y] = true;
        while (!queue.isEmpty()) {
            Pair now = queue.peek();
            queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + way[i][0];
                int ny = now.y + way[i][1];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !used[nx][ny] && grid[nx][ny] == '1') {
                    used[nx][ny] = true;
                    queue.add(new Pair(nx, ny));
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] used = new boolean[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                used[i][j] = false;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !used[i][j]) {
                    bfs(i, j, grid, used);
                    ans++;
                }
            }
        }
        return ans;
    }
}
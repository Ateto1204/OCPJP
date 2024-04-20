/**
 * https://leetcode.com/problems/find-all-groups-of-farmland
 * Problem ID: 1992. Find All Groups of Farmland
 *
 * Author: Ateto
 */

class Solution {
    private int n;
    private int m;
    private boolean[][] used;
    private int[][] way = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private class Pair {
        public final int x;
        public final int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private boolean isValid(int x, int y, int[][] land) {
        if (x >= 0 && y >= 0 && x < n && y < m && land[x][y] == 1 && !used[x][y]) {
            return true;
        }
        return false;
    }

    private Pair bfs(int x, int y, int[][] land) {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(x, y));
        used[x][y] = true;
        int rx = x;
        int ry = y;
        while (!queue.isEmpty()) {
            Pair now = queue.peek();
            queue.poll();
            rx = Integer.max(now.x, rx);
            ry = Integer.max(now.y, ry);
            for (int i = 0; i < 4; i++) {
                int nx = now.x + way[i][0];
                int ny = now.y + way[i][1];
                if (isValid(nx, ny, land)) {
                    used[nx][ny] = true;
                    queue.add(new Pair(nx, ny));
                }
            }
        }
        return new Pair(rx, ry);
    }

    public int[][] findFarmland(int[][] land) {
        List<int[]> pos = new ArrayList<>();
        n = land.length;
        m = land[0].length;
        used = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                used[i][j] = false;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !used[i][j]) {
                    Pair pair = bfs(i, j, land);
                    int[] tmp = new int[]{i, j, pair.x, pair.y};
                    pos.add(tmp);
                }
            }
        }

        int k = pos.size();
        int[][] result = new int[k][4];
        int idx = 0;
        for (int[] i : pos) {
            for (int j = 0; j < 4; j++) {
                result[idx][j] = i[j];
            }
            idx++;
        }
        return result;
    }
}
/*
 *
 * https://leetcode.com/problems/island-perimeter
 * Problem ID: 463. Island Perimeter
 * 
 * Author: Ateto
 * 
 */

class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int way[][] = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int edge = 4;
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = i + way[dir][0];
                        int ny = j + way[dir][1];
                        if (nx<n && ny<m && nx>=0 && ny>=0 && grid[nx][ny]==1) {
                            edge--;
                        }
                    }
                    result += edge;
                }
            }
        }
        return result;
    }
}
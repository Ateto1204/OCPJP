/**
 * https://leetcode.com/problems/word-search
 * Problem ID: 79. Word Search
 *
 * Author: Ateto
 */

class Solution {
    private int[][] way = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int n, m, length;

    private boolean dfs(int x, int y, int depth, char[][] board, String word) {
        if(depth == length) {
            return true;
        }

        char saved = board[x][y];
        board[x][y] = ' ';

        for(int i = 0; i < 4; i++) {
            int nx = x + way[i][0];
            int ny = y + way[i][1];
            if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if(board[nx][ny] == word.charAt(depth)) {
                    boolean flag = dfs(nx, ny, depth+1, board, word);
                    if(flag) {
                        board[x][y] = saved;
                        return true;
                    }
                }
            }
        }
        board[x][y] = saved;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        
        length = word.length();
        n = board.length;
        m = board[0].length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == word.charAt(0)) {
                    boolean flag = dfs(i, j, 1, board, word);
                    if(flag) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
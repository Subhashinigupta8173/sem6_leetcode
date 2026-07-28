import java.util.*;

class Solution {
    public void solve(char[][] board) {

        Queue<int[]> q = new LinkedList<>();

        int n = board.length;
        int m = board[0].length;

        // First row and Last row
        for (int i = 0; i < m; i++) {

            // First row
            if (board[0][i] == 'O') {
                q.offer(new int[]{0, i});
                board[0][i] = '#';
            }

            // Last row
            if (board[n - 1][i] == 'O') {
                q.offer(new int[]{n - 1, i});
                board[n - 1][i] = '#';
            }
        }

        // First column and Last column
        for (int i = 0; i < n; i++) {

            // First column
            if (board[i][0] == 'O') {
                q.offer(new int[]{i, 0});
                board[i][0] = '#';
            }

            // Last column
            if (board[i][m - 1] == 'O') {
                q.offer(new int[]{i, m - 1});
                board[i][m - 1] = '#';
            }
        }

        // Directions
        int[] dr = {0, 0, -1, 1};
        int[] dc = {-1, 1, 0, 0};

        // BFS
        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];

            for (int i = 0; i < 4; i++) {

                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < m &&
                    board[nr][nc] == 'O') {

                    // Safe mark
                    board[nr][nc] = '#';

                    // Queue me daal do
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        // Final traversal
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                // Surrounded O -> X
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

                // Safe # -> O
                else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}
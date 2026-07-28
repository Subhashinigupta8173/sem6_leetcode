class Solution {

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public void solve(char[][] board) {

        int n = board.length;
        int m = board[0].length;

        // First row and Last row
        for (int j = 0; j < m; j++) {

            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }

            if (board[n - 1][j] == 'O') {
                dfs(board, n - 1, j);
            }
        }

        // First column and Last column
        for (int i = 0; i < n; i++) {

            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }

            if (board[i][m - 1] == 'O') {
                dfs(board, i, m - 1);
            }
        }

        // Convert board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

                else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int r, int c) {

        int n = board.length;
        int m = board[0].length;

        // Base case
        if (r < 0 || r >= n || c < 0 || c >= m || board[r][c] != 'O') {
            return;
        }

        // Mark as safe
        board[r][c] = '#';

        // Visit 4 directions
        for (int i = 0; i < 4; i++) {
            dfs(board, r + dr[i], c + dc[i]);
        }
    }
}
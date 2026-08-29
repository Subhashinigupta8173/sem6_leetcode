class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    fresh++;
                }

            }
        }
        int min = 0;
        if (fresh == 0) {
            return 0;
        }
        int[] dc = { -1, 1, 0, 0 };
        int[] dr = { 0, 0, -1, 1 };
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            for (int j = 0; j < size; j++) {

                int[] top = q.poll();
                int r = top[0];
                int c = top[1];
                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if (nr >= 0 && nc >= 0 && nc < m && nr < n && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        fresh--;
                        q.offer(new int[] { nr, nc });
                    }
                }
            }
            min++;
        }
        return fresh == 0 ? min : -1;

    }
}
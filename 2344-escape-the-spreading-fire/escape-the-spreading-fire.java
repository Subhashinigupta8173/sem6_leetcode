import java.util.*;

class Solution {

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int maximumMinutes(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        int[][] fireTime = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(fireTime[i], Integer.MAX_VALUE);
        }

        // Multi-source BFS for fire
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    fireTime[i][j] = 0;
                    q.offer(new int[]{i, j});
                }

            }
        }

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int row = curr[0];
            int col = curr[1];

            for (int i = 0; i < 4; i++) {

                int nr = row + dr[i];
                int nc = col + dc[i];

                if (nr >= 0 &&
                    nr < m &&
                    nc >= 0 &&
                    nc < n &&
                    grid[nr][nc] != 2 &&
                    fireTime[nr][nc] == Integer.MAX_VALUE) {

                    fireTime[nr][nc] = fireTime[row][col] + 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        int low = 0;
        int high = 1000000000;
        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canReach(grid, fireTime, mid)) {

                ans = mid;
                low = mid + 1;

            } else {

                high = mid - 1;
            }
        }

        if (ans == 1000000000)
            return 1000000000;

        return ans;
    }

    private boolean canReach(int[][] grid, int[][] fireTime, int wait) {

        int m = grid.length;
        int n = grid[0].length;

        if (wait >= fireTime[0][0]) {
            return false;
        }

        Queue<int[]> q = new LinkedList<>();

        boolean[][] vis = new boolean[m][n];

        q.offer(new int[]{0, 0, wait});
        vis[0][0] = true;

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];
            int t = curr[2];

            if (r == m - 1 && c == n - 1) {

                if (t <= fireTime[r][c]) {
                    return true;
                }
            }

            for (int i = 0; i < 4; i++) {

                int nr = r + dr[i];
                int nc = c + dc[i];
                int nt = t + 1;

                if (nr >= 0 &&
                    nr < m &&
                    nc >= 0 &&
                    nc < n &&
                    !vis[nr][nc] &&
                    grid[nr][nc] != 2) {

                    if (nr == m - 1 && nc == n - 1) {

                        if (nt <= fireTime[nr][nc]) {

                            vis[nr][nc] = true;
                            q.offer(new int[]{nr, nc, nt});
                        }

                    } else {

                        if (nt < fireTime[nr][nc]) {

                            vis[nr][nc] = true;
                            q.offer(new int[]{nr, nc, nt});
                        }
                    }
                }
            }
        }

        return false;
    }
}
import java.util.*;

class Solution {
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    grid[i][j] = 1;

                    boolean closed = true;

                    while (!q.isEmpty()) {
                        int[] curr = q.poll();
                        int r = curr[0];
                        int c = curr[1];

                        if (r == 0 || c == 0 || r == n - 1 || c == m - 1) {
                            closed = false;
                        }

                        for (int[] d : dir) {
                            int nr = r + d[0];
                            int nc = c + d[1];

                            if (nr >= 0 && nc >= 0 && nr < n && nc < m
                                    && grid[nr][nc] == 0) {
                                grid[nr][nc] = 1;
                                q.add(new int[]{nr, nc});
                            }
                        }
                    }

                    if (closed) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
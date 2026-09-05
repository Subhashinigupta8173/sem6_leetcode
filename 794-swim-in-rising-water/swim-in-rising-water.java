class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = grid[0][0];
        // {time, row, col}
        pq.offer(new int[]{grid[0][0], 0, 0});
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int time = curr[0];
            int r = curr[1];
            int c = curr[2];

            if (r == n - 1 && c == n - 1) {
                return time;
            }
            for (int i = 0; i < 4; i++) {

                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < n) {

                    int newTime =
                        Math.max(time, grid[nr][nc]);

                    if (newTime < dist[nr][nc]) {

                        dist[nr][nc] = newTime;

                        pq.offer(
                            new int[]{newTime, nr, nc}
                        );
                    }
                }
            }
        }

        return -1;
    }
}
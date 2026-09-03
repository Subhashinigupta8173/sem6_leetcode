class Solution {
    public int minimumEffortPath(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;
        int[][] dist = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            java.util.Arrays.fill(dist[i], Integer.MAX_VALUE);
        }


        java.util.PriorityQueue<int[]> pq =
            new java.util.PriorityQueue<>(
                (a, b) -> a[0] - b[0]
            );

        dist[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});

        int[][] dirs = {
            {-1, 0},  // up
            {1, 0},   // down
            {0, -1},  // left
            {0, 1}    // right
        };

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int currEffort = curr[0];
            int r = curr[1];
            int c = curr[2];
            if (r == rows - 1 && c == cols - 1) {
                return currEffort;
            }
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nr < rows &&
                    nc >= 0 && nc < cols) {
                    int difference = Math.abs(
                        heights[r][c] - heights[nr][nc]
                    );
                    int newEffort = Math.max(
                        currEffort,
                        difference
                    );
                    if (newEffort < dist[nr][nc]) {

                        dist[nr][nc] = newEffort;

                        pq.offer(new int[]{
                            newEffort,
                            nr,
                            nc
                        });
                    }
                }
            }
        }

        return 0;
    }
}
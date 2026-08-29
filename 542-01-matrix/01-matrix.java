class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int [][] dist = new int [n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < n;i++){
            for(int j = 0; j < m;j++){
                if(mat[i][j] == 0){
                    dist[i][j] = 0;
                    q.offer(new int[] {i,j});
                }
                else{
                    dist[i][j] = -1;
                }
            }
        }
        int[] dr= {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        while(!q.isEmpty()){
            int[] top = q.poll();
            int index = top[0];
            int dis = top[1];
            for(int i = 0; i < 4; i++){
                int nr = index + dr[i];
                int nc = dis + dc[i];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && dist[nr][nc] == -1){
                    dist[nr][nc] = 1 + dist[index][dis];
                    q.offer(new int []{nr,nc});

                }
            }

        }
        return dist;
    }
}
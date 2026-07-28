class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int islands = 0;
        Queue<int []> q = new LinkedList<>();
        for(int i = 0; i < m ; i++){
            for(int j = 0;j < n;j++){
                if(grid[i][j] == '1'){
                    islands++;
                    grid[i][j] = '0';
                    q.offer(new int []{i,j});
                    while(!q.isEmpty()){
                        int [] curr = q.poll();
                        int r = curr[0];
                        int c = curr[1];
                        for(int k = 0 ; k < 4 ; k++){
                            int nr = r + dr[k];
                            int nc = c + dc[k];
                            if(nc >= 0 && nc < n && nr >= 0 && nr < m && grid[nr][nc] ==  '1'){
                                grid[nr][nc] = '0';
                                q.offer(new int[]{nr,nc});
                            }
                        }

                    }
                }

            }
        }
        return islands;


        
    }
}
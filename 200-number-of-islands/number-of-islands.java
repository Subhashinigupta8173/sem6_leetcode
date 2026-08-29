class Solution {
    boolean [][] visited;
    public int numIslands(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int count = 0 ;
        int[] dc = {-1, 1, 0, 0};
        int[] dr = {-0 ,0, -1, 1};
        Queue<int[]>q = new LinkedList<>();
        for(int i  =0;i < m;i++){
            for(int j = 0; j < n;j++){
                if(grid[i][j] == '1'){
                    grid[i][j] = 'A';
                    count++;
                    q.offer(new  int []{i,j});
                    while(!q.isEmpty()){
                        int [] top = q.poll();
                        int r = top[0];
                        int c = top[1];
                        for(int k  = 0;k<4;k++){
                            int nr = r + dr[k];
                            int nc = c + dc[k];
                            if(nr>= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1'){
                                q.offer(new int[]{nr,nc});
                                grid[nr][nc] = 'A';
                            }
                        }
                    }

                }
            }
        }
        return count;


    }
    

}
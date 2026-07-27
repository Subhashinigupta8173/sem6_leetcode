class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i =0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] == 2){
                    q.offer(new int []{i,j});
                }
                else if (grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if(fresh == 0){
            return 0;
        }
        int min = 0;
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        //apply bsf on all rotten oranges
        while(!q.isEmpty() && fresh >0){
            int size  = q.size();
            for(int i  = 0;i<size;i++){
                int [] curr = q.poll();
                int row = curr[0];
                int col = curr[1];
                
                for(int k = 0;k<4;k++){
                    int newRow = row+dr[k];
                    int newcol = col+dc[k];
                    if(newRow >= 0 && newRow<m && newcol>=0 &newcol <n && grid[newRow][newcol]==1){
                        grid[newRow][newcol] = 2;
                        fresh --;
                        q.offer(new int []{newRow,newcol});

                    }


                }


            }
            min++;
           

        }
        return fresh == 0 ? min : -1;
        
        
    }
}
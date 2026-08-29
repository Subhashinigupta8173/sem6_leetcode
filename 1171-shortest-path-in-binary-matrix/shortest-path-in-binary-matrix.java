class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1){
            return -1;
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,1});
        grid[0][0] = 1;
        int[] dr = {-1,-1,-1,0,0,1,1,1};
        int[] dc = {-1,0,1,-1,1,-1,0,1};

        while(!q.isEmpty()){
            int [] top = q.poll();
            int r = top[0];
            int c = top[1];
            int dist = top[2];
            if(r == n -1 && c == n - 1){
                return dist;

            }
            for(int k = 0; k < 8;k++){
                int newrow = r + dr[k];
                int newcol = c + dc[k];
                if(newrow >= 0 && newrow < n  && newcol >= 0 && newcol < n && grid[newrow][newcol] == 0 ){
                    grid[newrow][newcol] = 1;
                    q.offer(new int []{newrow,newcol,dist+1});
                }
            }

        }
        return -1;
        
    }
}
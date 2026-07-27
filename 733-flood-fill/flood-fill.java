class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int originalColor = image[sr][sc];
         if (originalColor == color)
            return image;

        Queue<int []>q = new LinkedList<>();
        
        q.offer(new int []{sr,sc});
        image[sr][sc] = color;
        int [] dr = {-1,1,0,0};
        int [] dc=  {0,0,-1,1};
        while(!q.isEmpty()){

            int[] curr =  q.poll();
            int r = curr[0];
            int c = curr[1];
            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == originalColor ){
                    image[nr][nc] = color;
                    q.offer(new int []{nr,nc});
                }
            }

        }
        return image;
    }
}
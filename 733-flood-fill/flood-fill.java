class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    int n = image.length;
    int m = image[0].length;
    

    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{sr,sc});
    int pixel =image[sr][sc];
    image[sr][sc] = color;
    int [] dr = {-1,1,0,0};
    int [] dc = {0,0,-1,1};
    if(pixel == color){
        return image;
    }
    while(!q.isEmpty()){
        int [] curr = q.poll();
        int r = curr[0];
        int c = curr[1];
        for(int i = 0; i<4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nc >= 0 && nc< m && nr >=0 && nr < n && image[nr][nc] == pixel ){
                q.offer(new int[]{nr,nc});
                image[nr][nc] = color;

            }
        }
    }
    return image;


        
    }
}
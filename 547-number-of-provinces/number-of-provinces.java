class Solution {
   
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int c = 0 ;
        for(int j = 0;j < n;j++){
            if(!visited[j]){
            c++;
            dfs(isConnected,visited,j);
                }       
            }
        return c;
       
    }



    
    public void dfs(int[][] isConnected,boolean [] visited,int i){
        visited[i] = true;
        for(int nbrs = 0; nbrs < isConnected.length;nbrs++){
            if(isConnected[i][nbrs] == 1 && !visited[nbrs]){

                dfs(isConnected,visited,nbrs);
            }
        }

    }

}
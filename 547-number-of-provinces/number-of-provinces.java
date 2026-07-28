class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n= isConnected.length;
        boolean [] visited = new boolean[n];
        int c =0;
        for(int  j=0;j<n;j++ ){
            if(!visited[j]){
                c++;
                dfs(j,isConnected,visited);
            }


        }
        return c;

          
    }
    public static void dfs(int nodeCity,int[][] isConnected,boolean [] visited){

        visited[nodeCity] = true;
        for(int i =0 ;i<isConnected.length;i++){
            if(isConnected[nodeCity][i] == 1 && !visited[i]){
                dfs(i,isConnected,visited);
            }
        }
    }
        
}
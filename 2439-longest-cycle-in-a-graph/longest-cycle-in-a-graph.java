class Solution {
    int max = -1;
    public int longestCycle(int[] edges) {
        int n = edges.length;
       
        boolean[] visited = new boolean[n];
        boolean[] path = new boolean[n];
        int [] depth = new int [n];
        int currentcount = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, edges, visited, path, n,depth,0);
            }
        }
        return max;

    }

    public void dfs(int node,int []edges ,boolean[]visited,boolean [] path,int n,int[] depth ,int currentcount){
        path[node] = true;
        visited[node] = true;
        depth[node] = currentcount;
        int nbrs  = edges[node];
        if(nbrs != -1){
            if(!visited[nbrs]){

                dfs(nbrs,edges,visited,path,n,depth,currentcount+1);
            }
            else if(path[nbrs]){
                int cycle = currentcount - depth[nbrs] + 1;
                max = Math.max(max,cycle);

            }
        }
        path[node] = false;
    }
}
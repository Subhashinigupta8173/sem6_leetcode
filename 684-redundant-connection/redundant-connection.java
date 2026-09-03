class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n =edges.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0 ;i <= n;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            boolean [] visited  = new boolean[n+1];
            if(dfs(u,v,adj,visited)){
                return edge;
            }
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return new int[0];

        
    }
    public boolean dfs(int curr ,int target,ArrayList<ArrayList<Integer>> adj,boolean[]visited){
        if(curr == target){
            return true;
        }
        visited[curr] = true;
        for(int nbr:adj.get(curr)){
            if(!visited[nbr]){
                if(dfs(nbr,target,adj,visited)){
                    return true;
                }
            }
        }
        return false;

    }
}
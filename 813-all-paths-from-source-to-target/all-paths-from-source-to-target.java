class Solution {
    List<List<Integer>>  ans = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer>  ways = new ArrayList<>();
        ways.add(0);
        dfs(0,graph,ways);
        return ans;
    
        
    }
    public  void dfs(int i,int [][] graph,List<Integer> ways){
        if(i == graph.length-1){
            ans.add(new ArrayList<>(ways));
            return ;
        }
        for(int nbrs : graph[i]){
            ways.add(nbrs);
            dfs(nbrs,graph,ways);
            ways.remove(ways.size()-1);
        }
    }
}
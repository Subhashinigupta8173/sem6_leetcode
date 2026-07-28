class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<Integer> ways = new LinkedList<>();
        ways.add(0);
        dfs(0, graph, ways);

        return ans;

        
    }
    private void dfs(int node,int[][] graph,List<Integer> ways){
        if(node == graph.length - 1){
            ans.add(new ArrayList<>(ways));
            return ;
        }
        for(int nbrs : graph[node]){
            ways.add(nbrs);
            dfs(nbrs,graph,ways);
            ways.remove(ways.size()-1);

        }
    }

}
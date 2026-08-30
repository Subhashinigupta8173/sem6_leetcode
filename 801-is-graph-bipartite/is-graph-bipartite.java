class Solution {
    public boolean isBipartite(int[][] graph) {
        int n  = graph.length;
        int [] color  = new int[n];
        Arrays.fill(color,-1);
        for(int i =0 ;i < n;i++){
            if(color[i] != -1){
                continue;
            }
            Queue<Integer> q = new LinkedList<>();
            color[i] = 0;
            q.offer(i);
            while(!q.isEmpty()){
                int node = q.poll();
                for(int nbrs :  graph[node]){
                    if(color[nbrs] == -1){
                        color[nbrs] = 1 - color[node];
                        q.offer(nbrs);
                    }
                    else if(color[nbrs] == color[node]){
                        return false;
                    }
                }
            }
        }
        return true;
        
    }
}
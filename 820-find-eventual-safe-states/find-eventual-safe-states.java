class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer>[] rev = new ArrayList[n];
        for(int i = 0; i<n;i++){
            rev[i]=new ArrayList<>();
        }
        int [] outdegree = new int [n];
        for(int i =0; i<n;i++){
            outdegree[i] = graph[i].length;
            for(int nbrs : graph[i]){
                rev[nbrs].add(i) ;//reverse edge create kr rha haiye,rev[1].add(0)
            }
        }
        Queue<Integer>q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(outdegree[i] == 0){
                q.offer(i);
            }
        }

        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();//outdegree 0 vale phle se hi node me hai jo ki termnial hai 
            ans.add(node);//isliye ans me directadd kar diya
            for(int parent: rev[node]){
                outdegree[parent]--;
                if(outdegree[parent] == 0){
                    q.offer(parent);
                }
            }
        }
        Collections.sort(ans);
        return ans;

         

        
    }
}
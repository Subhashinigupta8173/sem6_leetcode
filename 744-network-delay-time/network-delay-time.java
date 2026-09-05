class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());


        }
        for(int [] edge: times){
            int u = edge[0];
            int v = edge[1];
            int t = edge[2];
            adj.get(u).add(new int []{v,t});
        }
        int[] dist= new int [n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,k});

        while(!pq.isEmpty()){
            int []current = pq.poll();
            int time = current[0];
            int node = current[1];
            if(time > dist[node]){
                continue;
            }
            for(int []edge : adj.get(node)){
                int next = edge[0];
                int weight = edge [1];
                int newtime = time + weight;
                if(newtime < dist[next]){
                    dist[next] = newtime;
                    pq.offer(new int []{newtime,next});
                    
                }
            }
        }
        int ans = 0;
        for(int i = 1 ;i<=n; i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;

            }
            ans = Math.max(ans,dist[i]);
        }
        return ans;


        
    }
}
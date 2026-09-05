class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            
            adj.get(u).add(new int[]{v, weight});
            adj.get(v).add(new int[]{u, weight});
        }

        int answer = -1;
        int minCount = Integer.MAX_VALUE;

      
        for (int source = 0; source < n; source++) {

            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);

            dist[source] = 0;

         
            PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[0] - b[0]);

            pq.offer(new int[]{0, source});

           
            while (!pq.isEmpty()) {

                int[] curr = pq.poll();

                int distance = curr[0];
                int u = curr[1];

                if (distance > dist[u]) {
                    continue;
                }

                for (int[] edge : adj.get(u)) {

                    int v = edge[0];
                    int weight = edge[1];

                    int newDistance = distance + weight;

                    if (newDistance < dist[v]) {

                        dist[v] = newDistance;

                        pq.offer(new int[]{newDistance, v});
                    }
                }
            }

        
            int count = 0;

            for (int i = 0; i < n; i++) {

                if (i != source &&
                    dist[i] <= distanceThreshold) {

                    count++;
                }
            }

           
            if (count <= minCount) {
                minCount = count;
                answer = source;
            }
        }

        return answer;
    }
}
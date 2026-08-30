class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        ArrayList<Integer>[] reverse = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            reverse[i] = new ArrayList<>();
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int[] outdegree = new int[n];
        for (int i = 0; i < n; i++) {
            outdegree[i] = graph[i].length;
            for (int nbrs : graph[i]) {
                reverse[nbrs].add(i);
            }

        }
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (outdegree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int curr = q.poll();
            ans.add(curr);
            for (int node : reverse[curr]) {
                outdegree[node]--;
                if (outdegree[node] == 0) {
                    q.add(node);

                }
            }

        }
        Collections.sort(ans);
        return ans;

    }
}
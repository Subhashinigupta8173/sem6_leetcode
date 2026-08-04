class Solution {
    int nodes;
    int degree;
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {

            if (!visited[i]) {
                nodes = 0;
                degree = 0;
                dfs(i, adj, visited);
                int edgeCount = degree / 2;
                if (edgeCount == nodes * (nodes - 1) / 2) {
                    ans++;
                }
            }
        }

        return ans;
    }

    void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {

        vis[node] = true;

        nodes++;

        degree += adj.get(node).size();

        for (int nbr : adj.get(node)) {

            if (!vis[nbr]) {
                dfs(nbr, adj, vis);
            }
        }
    }
}
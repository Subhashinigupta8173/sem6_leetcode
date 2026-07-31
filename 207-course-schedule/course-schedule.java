class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
         int[] indegree = new int[numCourses];
        for(int[] pair : prerequisites){
            int course= pair[0];
            int prerequisite = pair[1];
            graph[prerequisite].add(course);
            indegree[course]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < numCourses; i++) {

            if(indegree[i] == 0)
                queue.add(i);
        }
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            count++;
            for(int nbrs:graph[node]){
                indegree[nbrs]--;
                if(indegree[nbrs]==0){
                    queue.add(nbrs);
                }
            }
        }
        return count == numCourses;


        

    }
}
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
       
        for(int i =0;i<numCourses;i++){
            adj.add(new ArrayList<>());
            
        }
        int [] indegree =  new int [numCourses];
        for(int [] pair:prerequisites){
            adj.get(pair[1]).add(pair[0]);
            indegree[pair[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i= 0; i<numCourses;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        int [] order =  new int[numCourses];
        int index =0;
        while(!q.isEmpty()){
            int curr   = q.poll();
            order[index++] = curr; // collectin  order of yte courses
            for(int next : adj.get(curr)){
                indegree[next]-- ;
                if(indegree[next] == 0){
                    q.offer(next);
                }

            }

        }
        if(index == numCourses){
            return order;
        }
        return new int[0];
    




        
    }
}
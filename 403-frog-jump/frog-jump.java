class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    Boolean[][] dp;
    public boolean canCross(int[] stones) {
        dp = new Boolean[stones.length][stones.length + 1];
        for(int i = 0; i < stones.length; i++){
            map.put(stones[i] , i);
        }
        return Frog(stones, 0, 0);

        
    }
    public boolean Frog(int [] stones, int i,int jump){
        if(i ==  stones.length - 1){
            return true;
        }
        if(dp[i][jump] != null){
            return dp[i][jump];
        }
        for(int nextjump = jump - 1; nextjump <= jump + 1; nextjump++){
            if(nextjump <= 0){
                continue;

            }
            int nextposition = stones[i] + nextjump;
            if(map.containsKey(nextposition)){
                int j = map.get(nextposition);
                if(Frog(stones, j, nextjump)){
                    return dp[i][jump] = true;
                }
            }
        }
        return dp[i][jump] = false;
    }
}
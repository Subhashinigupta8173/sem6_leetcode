class Solution {
    public int change(int sum, int[] coins) {
        int n  = coins.length;
        int[][] dp = new int[n + 1][sum + 1];
        
       
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if( i  == 0){
                    dp[i][j] = 0;
                }
                else if( j == 0){
                     dp[i][j] = 1;
                } 
                
               
                // Take the coin if possible
                else if (coins[i - 1] <= j) {

                    dp[i][j] = 
                            dp[i-1][j]
                             + dp[i][j - coins[i - 1]];
                
                }
                else {
                     dp[i][j] = dp[i-1][j];
                } 

            }
        }
        return dp[n][sum];
        
    }
}
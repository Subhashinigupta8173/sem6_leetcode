class Solution {
    public boolean predictTheWinner(int[] nums) {
        int  n = nums.length;
        int [] [] dp = new int [n][n];
        for(int i = 0; i < n ;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(nums,0 ,n-1,dp) >= 0;
    
        

    }
    public int solve (int [] nums,int i ,int j,int[][]dp){
        if( i == j){
            return nums[i];
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int takei = nums[i] - solve(nums,i+1,j,dp);
        int takej = nums[j] - solve(nums,i, j -1,dp );
        return dp[i][j] = Math.max(takei,takej);
    }
}
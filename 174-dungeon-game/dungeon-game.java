class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return MinimumHP(dungeon, 0, 0,dp);
    }

    public static int MinimumHP(int[][] dungeon, int i, int j,int[][] dp) {

        int m = dungeon.length;
        int n = dungeon[0].length;

      
        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }
         if (dp[i][j] != -1) {
            return dp[i][j];
        }

    
        if (i == m - 1 && j == n - 1) {
            return dp[i][j]=Math.max(1, 1 - dungeon[i][j]);
        }

        int right = MinimumHP(dungeon, i, j + 1,dp);
        int down = MinimumHP(dungeon, i + 1, j,dp);

        int min = Math.min(right, down);

        return dp[i][j]= Math.max(1, min - dungeon[i][j]);
    }
}
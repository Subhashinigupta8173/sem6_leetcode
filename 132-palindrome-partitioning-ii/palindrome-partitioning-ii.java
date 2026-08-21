import java.util.*;

class Solution {
    int[][] dp;
    boolean[][] pal;

    public int minCut(String s) {
        int n = s.length();

        dp = new int[n][n];
        pal = new boolean[n][n];

        // Precompute palindrome
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {

                if (s.charAt(i) == s.charAt(j) &&
                    (j - i <= 1 || pal[i + 1][j - 1])) {

                    pal[i][j] = true;
                }
            }
        }

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, n - 1);
    }

    public int solve(int i, int j) {
        if (i >= j) {
            return 0;
        }
        if (pal[i][j]) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int mn = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            if (pal[i][k]) {
                int temp = 1 + solve(k + 1, j);
                mn = Math.min(mn, temp);
            }
        }

        return dp[i][j] = mn;
    }
}
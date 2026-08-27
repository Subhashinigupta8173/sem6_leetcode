class Solution {

    int[][][] dp;
    int[] boxes;

    public int removeBoxes(int[] boxes) {

        this.boxes = boxes;

        int n = boxes.length;

        dp = new int[n][n][n];

        return solve(0, n - 1, 0);
    }

    private int solve(int l, int r, int k) {

        if (l > r) {
            return 0;
        }

        if (dp[l][r][k] != 0) {
            return dp[l][r][k];
        }

        int originalR = r;
        int originalK = k;

        // Last ke same boxes ko k mein add karo
        while (l < r && boxes[r] == boxes[r - 1]) {
            r--;
            k++;
        }

        // Option 1: abhi remove karo
        int ans = solve(l, r - 1, 0)
                + (k + 1) * (k + 1);

        // Option 2: same color ke saath merge karo
        for (int m = l; m < r; m++) {

            if (boxes[m] == boxes[r]) {

                int score =
                        solve(l, m, k + 1)
                        + solve(m + 1, r - 1, 0);

                ans = Math.max(ans, score);
            }
        }

        /*
         * Original state ke liye answer store karo
         */
        dp[l][originalR][originalK] = ans;

        return ans;
    }
}
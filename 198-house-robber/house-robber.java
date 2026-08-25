class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        return findMax(n - 1, nums, dp);
    }

    public static int findMax(int i, int[] nums, int[] dp) {
        if (i == 0) {
            return nums[0];
        }

        if (i < 0) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int take = nums[i] + findMax(i - 2, nums, dp);
        int notTake = findMax(i - 1, nums, dp);

        dp[i] = Math.max(take, notTake);

        return dp[i];
    }
}
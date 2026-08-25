class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        
        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);
        int case1 = findMax(nums, dp1, n - 1, 1);

        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);
        int case2 = findMax(nums, dp2, n - 2, 0);

        return Math.max(case1, case2);
    }

    public static int findMax(int[] nums, int[] dp, int i, int start) {

        if (i < start) {
            return 0;
        }

        if (i == start) {
            return nums[i];
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int take = nums[i] + findMax(nums, dp, i - 2, start);
        int notTake = findMax(nums, dp, i - 1, start);

        dp[i] = Math.max(take, notTake);

        return dp[i];
    }
}
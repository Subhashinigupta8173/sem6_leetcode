class Solution {

    public int rob(int[] nums) {

        int n = nums.length;

        // Agar sirf ek hi house hai
        if (n == 1)
            return nums[0];

        // Case 1: Last house ko ignore karo
        int case1 = helper(nums, 0, n - 2);

        // Case 2: First house ko ignore karo
        int case2 = helper(nums, 1, n - 1);

        return Math.max(case1, case2);
    }

    // House Robber I
    public int helper(int[] nums, int start, int end) {

        int prev2 = 0; // dp[i-2]
        int prev1 = 0; // dp[i-1]

        for (int i = start; i <= end; i++) {

            // Current house loot karo
            int take = nums[i] + prev2;

            // Current house skip karo
            int notTake = prev1;

            // Dono me se best
            int curr = Math.max(take, notTake);

            // DP shift
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
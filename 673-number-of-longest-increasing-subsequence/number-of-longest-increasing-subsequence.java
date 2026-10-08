class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;

        int[] count = new int[n];
        int[] dp = new int[n];

        Arrays.fill(count, 1);
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {

                if (nums[j] < nums[i]) {

                    if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }

                    else if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == max) {
                result += count[i];
            }
        }

        return result;
    }
}
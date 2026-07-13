class Solution {

    Boolean[][] dp;

    public boolean canPartition(int[] arr) {

        int sum = 0;

        for (int x : arr)
            sum += x;

        if (sum % 2 != 0)
            return false;

        int target = sum / 2;

        dp = new Boolean[arr.length][target + 1];

        return Subsetsum(arr, arr.length - 1, target);
    }

    public boolean Subsetsum(int[] arr, int index, int target) {

        if (target == 0)
            return true;

        if (index < 0 || target < 0)
            return false;

        if (dp[index][target] != null)
            return dp[index][target];

        boolean take = Subsetsum(arr, index - 1, target - arr[index]);
        boolean notTake = Subsetsum(arr, index - 1, target);

        dp[index][target] = take || notTake;

        return dp[index][target];
    }
}
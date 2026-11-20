class Solution {
    int [][]dp;
    public int maxSelectedElements(int[] nums) {
    
        int n = nums.length;
        Arrays.sort(nums);
        dp = new int[n+1][2];
        int result = 1;
        for(int i = 0; i <= n; i++){
            Arrays.fill(dp[i] , -1);
        }

        for (int i = 0; i < n; i++) {
            result = Math.max(result,
                    Math.max(Solve(i, 0, nums), Solve(i, 1, nums)));
        }

        return result;
    }

    public  int Solve(int i, int inc, int[] nums) {
        if(dp[i][inc] != -1){
            return dp[i][inc];
        }
        int curr = nums[i] + inc;
        int len = 1;

        // Option 1: Find curr + 1
        int j = FindCurrent(nums, i + 1, curr + 1);

        if (j != -1) {
            len = Math.max(len, 1 + Solve(j, 0, nums));
        }

        // Option 2: Find curr
        j = FindCurrent(nums, i + 1, curr);

        if (j != -1) {
            len = Math.max(len, 1 + Solve(j, 1, nums));
        }

        return dp[i][inc] = len;
    }

    public static int FindCurrent(int[] nums, int i, int target) {
        int ans = -1;
        int n = nums.length;

        while (i < n) {
            int mid = i + (n - i) / 2;

            if (nums[mid] == target) {
                ans = mid;
                n = mid;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                n = mid;
            }
        }

        return ans;
    }
}
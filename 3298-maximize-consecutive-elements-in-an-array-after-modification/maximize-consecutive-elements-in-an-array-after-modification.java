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

        for(int i = n-1; i>=0; i--){
            for(int inc = 0; inc <= 1; inc++){
                int curr = nums[i] + inc;
                int len = 1;
                int j = FindCurrent(nums, i + 1, curr + 1);
                if (j != -1) {
                    len = Math.max(len, 1 + dp[j][0]);
                }
                j = FindCurrent(nums, i + 1, curr);

                if (j != -1) {
                    len = Math.max(len, 1 + dp[j][1]);
                }     
                dp[i][inc] = len;
                result = Math.max(result,len);


 
            }
        }

        return result;
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
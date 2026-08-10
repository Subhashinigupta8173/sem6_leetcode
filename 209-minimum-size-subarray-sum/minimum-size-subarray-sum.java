class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ei  = 0;
        int si = 0;
        int ans = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        while(ei<n){
            sum += nums[ei];
            ei++;
            while(sum  >= target){
                ans = ei - si;
                min = Math.min(min, ans);
                sum -= nums[si];
                si++;
            }
        }
        if (min == Integer.MAX_VALUE) {
            return 0;
        }
        return  min; 

        
    }
}
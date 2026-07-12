class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int [] maxDp = new int [n];
        int [] minDp = new int [n];
        maxDp[0] = nums[0];
        minDp[0] = nums[0];
        int ans = nums[0];
        for(int i=1; i < n; i++){
            int a = nums[i];
            int b= nums[i] * maxDp[i - 1];
            int c = nums[i] * minDp[i - 1];
            maxDp[i] = Math.max(a, Math.max(b, c));
            minDp[i] = Math.min(a, Math.min(b, c));
            ans = Math.max(ans, maxDp[i]);
            
        
        }
        return ans;

        
    }
}
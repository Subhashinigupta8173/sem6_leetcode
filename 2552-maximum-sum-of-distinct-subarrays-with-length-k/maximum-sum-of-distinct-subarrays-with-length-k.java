class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        long sum = 0;
        long ans = 0;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            while (set.contains(nums[r])) {
                set.remove(nums[l]);
                sum -= nums[l];
                l++;
            }
            set.add(nums[r]);
            sum += nums[r];
            if (r - l + 1 == k) {
                ans = Math.max(ans, sum);
                set.remove(nums[l]);
                sum -= nums[l];
                l++;
            }
        }
        return ans;
    }
}
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int asc = 0;
        int desc = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] == (nums[i - 1] + 1) % n) {
                asc++;
            }
            if (nums[i - 1] == (nums[i] + 1) % n) {
                desc++;
            }
        }

        if (asc == n - 1 && nums[0] == 0) {
            return 0;
        }

        if (asc == n - 1) {
            int leftrot = n - nums[0];
            int rightrot = 1 + (nums[n - 1] + 1) + 1;
            return Math.min(leftrot, rightrot);
        }

        if (desc == n - 1) {
            int leftrot = n - nums[n - 1] + 1;
            int rightrot = (nums[0] + 1) % n + 1;
            return Math.min(leftrot, rightrot);
        }

        return -1;
    }
}
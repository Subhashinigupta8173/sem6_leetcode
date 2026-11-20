
class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        boolean f = false;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            int sum = 0;

            for (int j = i; j < nums.size(); j++) {
                sum += nums.get(j);

                int len = j - i + 1;

                if (len >= l && len <= r) {
                    if (sum > 0) {
                        min = Math.min(min, sum);
                        f = true;
                    }
                }
            }
        }

        if (f) {
            return min;
        } else {
            return -1;
        }
    }
}

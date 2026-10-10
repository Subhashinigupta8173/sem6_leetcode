class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] diff = new int[n];
        long total = 0;
        int maxdiff = 0;
        long k = (long) k1 + k2;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            total += diff[i];
            maxdiff = Math.max(maxdiff, diff[i]);
        }

        if (total <= k) {
            return 0;
        }

        int low = 0;
        int high = maxdiff;

        while (low < high) {
            int mid = low + (high - low) / 2;
            long operations = 0;

            for (int d : diff) {
                operations += Math.max(0, d - mid);
            }

            if (operations <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        int t = low;
        long remaining = k;

        for (int d : diff) {
            remaining -= Math.max(0, d - t);
        }

        long result = 0;

        for (int d : diff) {
            d = Math.min(d, t);

            if (d == t && remaining > 0) {
                d--;
                remaining--;
            }

            result += (long) d * d;
        }

        return result;
    }
}
class Solution {

    public int minDays(int[] bloomDay, int m, int k) {

        // Total flowers hi kam hain
        if ((long)m * k > bloomDay.length)
            return -1;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        // Minimum aur maximum bloom day nikal lo
        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canMake(bloomDay, mid, m, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public boolean canMake(int[] bloomDay, int day, int m, int k) {

        int flowers = 0;
        int bouquet = 0;

        for (int bloom : bloomDay) {

            if (bloom <= day) {

                flowers++;

                if (flowers == k) {
                    bouquet++;
                    flowers = 0;
                }

            } else {

                flowers = 0;
            }

        }

        return bouquet >= m;
    }
}
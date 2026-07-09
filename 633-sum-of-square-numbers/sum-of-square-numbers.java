class Solution {
    public boolean judgeSquareSum(int c) {

        for (long a = 0; a * a <= c; a++) {

            long target = c - a * a;

            int low = 0;
            int high = (int)Math.sqrt(target);

            while (low <= high) {
                int mid = low + (high - low) / 2;
                long square = 1L * mid * mid;

                if (square == target) {
                    return true;
                } else if (square < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }
}
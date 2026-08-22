class Solution {
    public int numberOfArithmeticSlices(int[] arr) {
        int n = arr.length;

        if (n < 3) {
            return 0;
        }

        int count = 0;
        int ans = 0;

        for (int i = 2; i < n; i++) {

            if (arr[i] - arr[i - 1] == arr[i - 1] - arr[i - 2]) {
                count++;
                ans += count;
            } else {
                count = 0;
            }
        }

        return ans;
    }
}
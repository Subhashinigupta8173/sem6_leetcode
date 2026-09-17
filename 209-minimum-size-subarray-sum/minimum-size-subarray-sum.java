class Solution {
    public int minSubArrayLen(int target, int[] arr) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            while (sum >= target) {
                min = Math.min(min, i - start + 1);
                sum -= arr[start];
                start++;
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = 1000000007;
        int even_count = 1;
        int odd_count = 0;
        int sum = 0;
        long result = 0;
        for (int num : arr) {
            sum += num;
            if (sum % 2 == 0) {
                result = (result + odd_count) % mod;
                even_count++;
            }
            else {
                result = (result + even_count) % mod;
                odd_count++;
            }
        }
        return (int) result;
    }
}
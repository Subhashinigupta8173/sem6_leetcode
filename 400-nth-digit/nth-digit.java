class Solution {
    public int findNthDigit(int n) {

        long len = 1;
        long count = 9;
        long start = 1;

        while (n > len * count) {
            n -= len * count;
            len++;
            count *= 10;
            start *= 10;
        }

        long number = start + (n - 1) / len;
        int index = (int)((n - 1) % len);

        return Long.toString(number).charAt(index) - '0';
    }
}
class Solution {
    static final int MOD = 1000000007;

    public int countGoodNumbers(long n) {
        long even = (n + 1) / 2;
        long odd = n / 2;

        return (int)((power(5, even) * power(4, odd)) % MOD);
    }

    public long power(long x, long n) {
        if (n == 0) return 1;

        long half = power(x, n / 2);

        if (n % 2 == 0) return (half * half) % MOD;
        return (half * half % MOD * x) % MOD;
    }
}
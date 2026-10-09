class Solution {
    int c = 0;
    public int countArrangement(int n) {
        c = 0;
        boolean[] used = new boolean[n + 1];
        Solve(1, n, used);
        return c;
    }
    public void Solve(int pos, int n, boolean[] used) {
        if (pos > n) {
            c++;
            return;
        }

        for (int num = 1; num <= n; num++) {
            if (!used[num] &&
                (num % pos == 0 || pos % num == 0)) {
                used[num] = true;
                Solve(pos + 1, n, used);
                used[num] = false;
            }
        }
    }
}
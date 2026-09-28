class Solution {
    public char kthCharacter(long k, int[] operations) {

        long len = 1;
        int shift = 0;

        int n = 0;

        // Sirf utni length banao jitni k tak pahunchne ke liye needed hai
        while (len < k) {
            len = len * 2;
            n++;
        }

        // Reverse mein sirf relevant operations dekho
        for (int i = n - 1; i >= 0; i--) {

            long half = len / 2;

            if (k > half) {
                k = k - half;

                if (operations[i] == 1) {
                    shift++;
                }
            }

            len = half;
        }

        return (char) ('a' + (shift % 26));
    }
}
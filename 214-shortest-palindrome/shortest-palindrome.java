class Solution {
    public String shortestPalindrome(String s) {
        StringBuilder rev = new StringBuilder(s).reverse();
        String combined = s + "#" + rev;

        int n = combined.length();
        int[] lps = new int[n];

        int len = 0;
        int i = 1;

        while (i < n) {
            if (combined.charAt(i) == combined.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        int longest = lps[n - 1];
        String suffix = s.substring(longest);

        return new StringBuilder(suffix).reverse().toString() + s;
    }
}
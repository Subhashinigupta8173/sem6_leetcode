class Solution {

    HashMap<String, Integer> memo = new HashMap<>();
    int INF = 100;

    public int findMinStep(String board, String hand) {

        int[] count = new int[26];

        for (char c : hand.toCharArray()) {
            count[c - 'A']++;
        }

        int ans = dfs(board, count);

        return ans == INF ? -1 : ans;
    }

    int dfs(String board, int[] hand) {

        board = remove(board);

        if (board.length() == 0) {
            return 0;
        }

        String key = board + Arrays.toString(hand);

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int ans = INF;

        // Try every ball color
        for (int k = 0; k < 26; k++) {

            if (hand[k] == 0) {
                continue;
            }

            char ch = (char) ('A' + k);

            // Try every insertion position
            for (int i = 0; i <= board.length(); i++) {

                // Avoid useless insertions.
                // We only insert:
                // 1. next to the same color
                // 2. between two same-colored balls
                if (i < board.length() && board.charAt(i) == ch) {

                    hand[k]--;

                    String next =
                        board.substring(0, i)
                        + ch
                        + board.substring(i);

                    int result = dfs(next, hand);

                    if (result != INF) {
                        ans = Math.min(ans, 1 + result);
                    }

                    hand[k]++;
                }

                else if (i > 0 && i < board.length()
                        && board.charAt(i - 1) == board.charAt(i)) {

                    hand[k]--;

                    String next =
                        board.substring(0, i)
                        + ch
                        + board.substring(i);

                    int result = dfs(next, hand);

                    if (result != INF) {
                        ans = Math.min(ans, 1 + result);
                    }

                    hand[k]++;
                }
            }
        }

        memo.put(key, ans);

        return ans;
    }

    String remove(String board) {

        boolean changed = true;

        while (changed) {

            changed = false;

            for (int i = 0; i < board.length();) {

                int j = i;

                while (j < board.length()
                        && board.charAt(j) == board.charAt(i)) {
                    j++;
                }

                if (j - i >= 3) {

                    board = board.substring(0, i)
                           + board.substring(j);

                    changed = true;
                    break;
                }

                i = j;
            }
        }

        return board;
    }
}
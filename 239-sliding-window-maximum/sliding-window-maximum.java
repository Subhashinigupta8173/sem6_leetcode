class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] ans = new int[n - k + 1];

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> b[0] - a[0]);

        int si = 0;

        for (int ei = 0; ei < n; ei++) {

            // value + index
            pq.add(new int[]{nums[ei], ei});

            // window se bahar wale elements remove
            while (pq.peek()[1] < si) {
                pq.poll();
            }

            // window size k
            if (ei - si + 1 == k) {

                ans[si] = pq.peek()[0];

                si++;
            }
        }

        return ans;
    }
}
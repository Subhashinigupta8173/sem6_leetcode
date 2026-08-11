class Solution {

    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    public int atMost(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int ei = 0;
        int si = 0;
        int ans = 0;
        int n = nums.length;

        while (ei < n) {

            map.put(nums[ei], map.getOrDefault(nums[ei], 0) + 1);
            ei++;

            if (map.size() > k) {

                while (map.size() > k) {

                    int val = nums[si];

                    if (map.get(val) == 1) {
                        map.remove(val);
                    } else {
                        map.put(val, map.get(val) - 1);
                    }

                    si++;
                }
            }

            ans += ei - si;
        }

        return ans;
    }
}
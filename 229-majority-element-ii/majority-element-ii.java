
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ll = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        int n = nums.length;
        int c = n / 3;

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (int key : map.keySet()) {
            int ans = map.get(key);

            if (ans > c) {
                ll.add(key);
            }
        }

        return ll;
    }
}
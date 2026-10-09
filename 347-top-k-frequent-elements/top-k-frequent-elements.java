
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] arr = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer> ll = new ArrayList<>(map.keySet());

        ll.sort((a, b) -> map.get(b) - map.get(a));

        for (int i = 0; i < k; i++) {
            arr[i] = ll.get(i);
        }

        return arr;
    }
}
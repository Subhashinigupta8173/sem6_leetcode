class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int lt = 0, eq = 0;
        for (int x : nums) {
            if (x < target) lt++;
            else if (x == target) eq++;
        }
        List<Integer> res = new ArrayList<>(eq);
        for (int i = 0; i < eq; i++) res.add(lt + i);
        return res;
    }
}

import java.util.*;

class Solution {
    public int sumCounts(List<Integer> nums) {
        int sum = 0;
        int n = nums.size();

        for (int i = 0; i < n; i++) {
            HashSet<Integer> ll = new HashSet<>();

            for (int j = i; j < n; j++) {
                if (!ll.contains(nums.get(j))) {
                    ll.add(nums.get(j));
                }

                sum += ll.size() * ll.size();
            }
        }

        return sum;
    }
}
